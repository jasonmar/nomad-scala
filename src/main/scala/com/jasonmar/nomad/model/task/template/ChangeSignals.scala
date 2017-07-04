package com.jasonmar.nomad.model.task.template

import com.jasonmar.hcl.Parameter

object ChangeSignals {
  sealed trait ChangeSignal extends Parameter
  case object SIGABRT extends ChangeSignal { override val value: String = "SIGABRT" } //	6	Terminate (core dump)	Process abort signal
  case object SIGALRM extends ChangeSignal { override val value: String = "SIGALRM" } //	14	Terminate	Alarm clock
  case object SIGBUS extends ChangeSignal { override val value: String = "SIGBUS" } //	 	Terminate (core dump)	Access to an undefined portion of a memory object.
  case object SIGCHLD extends ChangeSignal { override val value: String = "SIGCHLD" } //	 	Ignore	Child process terminated, stopped, or continued.
  case object SIGCONT extends ChangeSignal { override val value: String = "SIGCONT" } //	 	Continue	Continue executing, if stopped.
  case object SIGFPE extends ChangeSignal { override val value: String = "SIGFPE" } //	 	Terminate (core dump)	Erroneous arithmetic operation.
  case object SIGHUP extends ChangeSignal { override val value: String = "SIGHUP" } //	1	Terminate	Hangup.
  case object SIGILL extends ChangeSignal { override val value: String = "SIGILL" } //	 	Terminate (core dump)	Illegal instruction.
  case object SIGINT extends ChangeSignal { override val value: String = "SIGINT" } //	2	Terminate	Terminal interrupt signal.
  case object SIGKILL extends ChangeSignal { override val value: String = "SIGKILL" } //	9	Terminate	Kill (cannot be caught or ignored).
  case object SIGPIPE extends ChangeSignal { override val value: String = "SIGPIPE" } //	 	Terminate	Write on a pipe with no one to read it.
  case object SIGPOLL extends ChangeSignal { override val value: String = "SIGPOLL" } //	 	Terminate	Pollable event.
  case object SIGPROF extends ChangeSignal { override val value: String = "SIGPROF" } //	 	Terminate	Profiling timer expired.
  case object SIGQUIT extends ChangeSignal { override val value: String = "SIGQUIT" } //	3	Terminate (core dump)	Terminal quit signal.
  case object SIGSEGV extends ChangeSignal { override val value: String = "SIGSEGV" } //	 	Terminate (core dump)	Invalid memory reference.
  case object SIGSTOP extends ChangeSignal { override val value: String = "SIGSTOP" } //	 	Stop	Stop executing (cannot be caught or ignored).
  case object SIGSYS extends ChangeSignal { override val value: String = "SIGSYS" } //	 	Terminate (core dump)	Bad system call.
  case object SIGTERM extends ChangeSignal { override val value: String = "SIGTERM" } //	15	Terminate	Termination signal.
  case object SIGTRAP extends ChangeSignal { override val value: String = "SIGTRAP" } //	5	Terminate (core dump)	Trace/breakpoint trap.
  case object SIGTSTP extends ChangeSignal { override val value: String = "SIGTSTP" } //	 	Stop	Terminal stop signal.
  case object SIGTTIN extends ChangeSignal { override val value: String = "SIGTTIN" } //	 	Stop	Background process attempting read.
  case object SIGTTOU extends ChangeSignal { override val value: String = "SIGTTOU" } //	 	Stop	Background process attempting write.
  case object SIGUSR1 extends ChangeSignal { override val value: String = "SIGUSR1" } //	 	Terminate	User-defined signal 1.
  case object SIGUSR2 extends ChangeSignal { override val value: String = "SIGUSR2" } //	 	Terminate	User-defined signal 2.
  case object SIGURG extends ChangeSignal { override val value: String = "SIGURG" } //	 	Ignore	High bandwidth data is available at a socket.
  case object SIGVTALRM extends ChangeSignal { override val value: String = "SIGVTALRM" } //	 	Terminate	Virtual timer expired.
  case object SIGXCPU extends ChangeSignal { override val value: String = "SIGXCPU" } //	 	Terminate (core dump)	CPU time limit exceeded.
  case object SIGXFSZ extends ChangeSignal { override val value: String = "SIGXFSZ" } //	 	Terminate (core dump)	File size limit exceeded
}