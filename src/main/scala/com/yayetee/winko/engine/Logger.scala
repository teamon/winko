package com.yayetee.winko.engine

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:10:14
 */

object Logger {
	def debug(msg: String){
		println("[DEBUG] " + msg)
	}

	def debug(pattern: String, args: Any*){
		print("[DEBUG] ")
		printf(pattern, args:_*)
		print("\n")

	}

	def info(msg: String){
		println("[INFO] " + msg)
	}

	def info(pattern: String, args: Any*){
		print("[INFO] ")
		printf(pattern, args:_*)
		print("\n")
	}
}
