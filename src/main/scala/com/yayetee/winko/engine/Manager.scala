package com.yayetee.winko.engine

import scala.collection.mutable.ListBuffer
import TUIO._

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:03:20
 */

/**
 * Master object manager
 *
 * Listens to TUIO messages
 */

object Manager extends TuioListener {
	val entities = new ListBuffer[Entity]

	// TUIO Listeners

	def addTuioObject(tobj: TuioObject) {
		val entity = Engine.app.createObject(tobj)
		entity.fireCallbacks("oncreate")
		entities += entity
	}

	def updateTuioObject(tobj: TuioObject) {
		entities.find(_.tobj == tobj).map(_.fireCallbacks("onupdate"))
	}

	def removeTuioObject(tobj: TuioObject) {
		entities.find(_.tobj == tobj).map(e => {
			e.fireCallbacks("onremove")
			entities -= e
		})
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
		//		Logger.debug("Tuio refresh ", frameTime)
	}

}
