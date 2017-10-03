package com.jasonmar

import java.io.{File, FileOutputStream, OutputStreamWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths}

import com.jasonmar.nomad.model.task.Task

import scala.collection.JavaConverters.asScalaIteratorConverter
import scala.util.{Failure, Try}

package object nomad {

  protected def listFiles(p: Path): Vector[Path] = {
    val b = Array.newBuilder[Path]
    val s = scala.collection.mutable.Stack[Path]()

    s.push(p)
    while (s.nonEmpty){
      s.pop() match {
        case dir if Files.isDirectory(dir) =>
          val ds = Files.newDirectoryStream(dir)
          ds.iterator().asScala.foreach{
            case subdir if Files.isDirectory(subdir) && !subdir.toFile.getName.startsWith(".") =>
              s.push(subdir)
            case file if Files.isRegularFile(file) =>
              val fileName = file.toFile.getName
              if (fileName.endsWith(".hcl") || !fileName.startsWith(".")){
                b += file
              } else {
                System.out.println(s"Ignoring $file")
              }
            case _ =>
          }
          ds.close()
        case file if Files.isRegularFile(file) =>
          b += file
      }
    }

    b.result().toVector
  }

  /** Deletes a file only if it is a file and not a directory
    *
    * @param f file to delete
    */
  protected def deleteFile(f: File): Unit = {
    if (f.isFile && f.getName.endsWith(".hcl")){
      System.out.println(s"Deleting ${f.getAbsolutePath}")
      f.delete()
    } else {
      throw new Exception(s"Can't delete ${f.getAbsolutePath}")
    }
  }

  def printTask(task: Task, outPath: Path, overwrite: Boolean = false): Unit = {
    val taskPath = outPath.resolve(task.name + ".hcl")
    val f = taskPath.toFile
    if (f.exists){
      if (overwrite) deleteFile(f)
      else throw new Exception(s"Can't overwrite ${f.getAbsolutePath}")
    }
    if (!f.exists){
      System.out.println(s"Writing ${f.getAbsolutePath}")
      val os = new FileOutputStream(f)
      val writer = new OutputStreamWriter(os, StandardCharsets.UTF_8)
      writer.write(task.printHCL)
      writer.flush()
      os.flush()
      writer.close()
      os.close()
    } else {
      throw new Exception(s"Already exists: $taskPath")
    }
  }

  /** Removes contents of a directory not beginning with "."
    *
    * @param outPath directory to clear
    */
  protected def clearDirectoryContents(outPath: Path): Unit = {
    if (outPath.toFile.isDirectory){
      System.out.println(s"Removing files from $outPath")
      val files = listFiles(outPath)
      files.foreach{f =>
        System.out.println(s"Deleting $f")
        Files.delete(f)
      }
    }
  }

  def printTasks(tasks: Seq[Task], outDir: String, overwrite: Boolean = false): Unit = {
    val outPath = Paths.get(outDir)
    val f = outPath.toFile
    if (!f.exists) {
      System.out.println(s"Creating directory ${f.getAbsolutePath}")
      f.mkdirs()
    }
    tasks.foreach(t => printTask(t, outPath, overwrite))
  }

  def printTaskMap(tasks: Map[String,Seq[Task]], overwrite: Boolean = false): Unit = {
    tasks.foreach{x =>
      val (outPath,tasks) = x
      printTasks(tasks, outPath, overwrite)
    }
  }

  protected trait TaskWriter {
    def write(baseDir: String, overWrite: Boolean = true): Unit
  }

  protected trait TaskWriterApp extends TaskWriter {
    def main(args: Array[String]): Unit = {
      if (args.length == 0){
        System.out.println("Usage: TaskWriter <baseDir> [--overwrite] [--clear]")
        sys.exit(1)
      }
      val baseDir = args.headOption.getOrElse(".")
      val a = args.drop(1).toSet
      val overWrite = a.contains("--overwrite")
      val clear = a.contains("--clear")
      if (overWrite) System.out.println(s"overwrite enabled")
      if (clear) System.out.println(s"clear existing directory enabled")

      if (clear){
        clearDirectoryContents(Paths.get(baseDir))
      }

      System.out.println(s"Writing HCL to $baseDir")
      Try(write(baseDir, overWrite)) match {
        case Failure(e) =>
          System.err.println(s"Failed to write HCL to $baseDir")
          System.err.println(e.getMessage)
          System.exit(1)
        case _ =>
          System.out.println(s"Finished writing HCL to $baseDir")
      }
    }
  }

  trait TaskInventory extends TaskWriterApp {
    val tasks: Seq[Task]
    val outDir: String
    override def write(baseDir: String, overWrite: Boolean = false): Unit = {
      printTasks(
        tasks,
        Paths.get(baseDir).resolve(outDir).toFile.getAbsolutePath,
        overWrite
      )
    }
  }

  trait GlobalInventory extends TaskWriterApp {
    val inventories: Seq[TaskInventory]
    override def write(baseDir: String, overWrite: Boolean = true): Unit = {
      inventories.foreach(_.write(baseDir, overWrite))
    }
  }
}
