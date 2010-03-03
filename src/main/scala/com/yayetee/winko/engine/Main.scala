package com.yayetee.winko.engine

import com.yayetee.winko.gui.Processing
import TUIO.TuioClient

/**
 * Created by IntelliJ IDEA.
 * User: teamon
 * Date: 2010-03-03
 * Time: 14:14:30
 */

object Main {	
	def main(args: Array[String]){
		Logger.info("Starting up")
//		Processing.init

		Logger.info("Loading TUIO")
		val client = new TuioClient
    client.addTuioListener(new Listener)
    client.connect

		Logger.info("Ready to go!")
	}
}
