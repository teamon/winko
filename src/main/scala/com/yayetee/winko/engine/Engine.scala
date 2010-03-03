package com.yayetee.winko.engine

import com.yayetee.winko.apps.demo.Demo
import TUIO.{TuioObject, TuioClient}
import com.yayetee.winko.gui.Processing // temporary

/**
 * Created by IntelliJ IDEA.
 * User: teamon
 * Date: 2010-03-03
 * Time: 14:14:30
 */

class Dimension(val width: Int, val height: Int)

abstract class Application {
	def run {Engine runApplication this}

	def createObject(obj: TuioObject): Entity
}

object Engine {
	val resolution = new Dimension(1024, 768)
	var app: Application = _

	def main(args: Array[String]) {
		Logger.info("Starting up")
		Processing.init

		Logger.info("Loading TUIO")
		val client = new TuioClient
		client.addTuioListener(Manager)
		client.connect

		Logger.info("Ready to go!")

		Demo.run // temporary!
	}

	def runApplication(app: Application) {
		this.app = app
	}

}
