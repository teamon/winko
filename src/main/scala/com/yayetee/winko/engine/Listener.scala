package com.yayetee.winko.engine

import TUIO._

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:04:31
 */

/**
 *TuioListener class implementation
 */

class Listener extends TuioListener {
	def addTuioObject(tobj: TuioObject) {
		Logger.debug("TuioObject added {0}", tobj)
	}

	def updateTuioObject(tobj: TuioObject) {
		Logger.debug("TuioObject updated {0}", tobj)
	}

	def removeTuioObject(tobj: TuioObject) {
		Logger.debug("TuioObject removed {0}", tobj)
	}

	def addTuioCursor(tcur: TuioCursor) {
		Logger.debug("TuioCursor added {0}", tcur)
	}

	def updateTuioCursor(tcur: TuioCursor) {
		Logger.debug("TuioCursor updated {0}", tcur)
	}

	def removeTuioCursor(tcur: TuioCursor) {
		Logger.debug("TuioCursor removed {0}", tcur)
	}

	def refresh(frameTime: TuioTime) {
		Logger.debug("Tuio refresh ", frameTime)
	}
}
