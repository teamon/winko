package com.yayetee.winko.engine

import collection.mutable.ListBuffer
import collection.mutable.Map

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 18:33:09
 */

trait Callbacks {
	val callbacks = Map[String, ListBuffer[() => Unit]]()

	def registerCallback(name: String, f: () => Unit) {
		if (!callbacks.contains(name)) {
			callbacks += name -> new ListBuffer[() => Unit]
		}

		callbacks(name) += f
	}

	def fireCallbacks(name: String) {
		if (callbacks.contains(name)) callbacks(name).foreach(_())
	}
}




