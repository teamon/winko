package com.yayetee.winko.engine

import collection.mutable.ListBuffer

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 18:25:48
 */

trait Animations extends Callbacks {
	val animations = new ListBuffer[Animation]

	def animate(animation: Animation) {
		animations.append(animation)
		animation.start
	}

	registerCallback("onremove", () => {
		Logger.debug("Animations onremove")
		animations.foreach(_.stopAnimation)
	})
}

case class StopAnimation

abstract class Animation extends Thread {
	var keep = true

	def stopAnimation {keep = false}
}

class FloatAnimation(val from: Float, val to: Float, val step: Float, val timeout: Int, val func: Float => Unit) extends Animation {
	var current = from


	override def run {
		while (keep) {
			current += step
			if (current > to) current = from
			func(current)

			Thread.sleep(timeout)
		}
	}


}
