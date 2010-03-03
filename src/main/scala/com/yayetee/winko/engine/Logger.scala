package com.yayetee.winko.engine

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:10:14
 */

class LoggerException extends Exception

object Logger {
	def debug(msg: String){
		println("[DEBUG] " + msg + from)
	}

	def debug(pattern: String, args: Any*){
		print("[DEBUG] ")
		printf(pattern, args:_*)
		println(from)
	}

	def info(msg: String){
		println("[INFO] " + msg)
	}

	def info(pattern: String, args: Any*){
		print("[INFO] ")
		printf(pattern, args:_*)
		print("\n")
	}

	protected def from = {
		var from = ""
		try {
			throw new LoggerException
		} catch {
			case e:LoggerException => from = e.getStackTrace()(2).toString
		}
		" (" + from + ")"
	}
}
