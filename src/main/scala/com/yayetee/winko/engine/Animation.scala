package com.yayetee.winko.engine

import collection.mutable.ListBuffer
import Math._

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

abstract class Animation(val timeout: Int) extends Thread {
	var keep = true

	def stopAnimation {keep = false}

	override def run {
		while (keep) {
			tick
			Thread.sleep(timeout)
		}
	}

	def tick
}

class LinearAnimation[T](val from: T, val to: T, val step: T, timeout: Int, val func: T => Unit)(implicit n: Numeric[T]) extends Animation(timeout) {
	import n._
	var current = from

	override def tick {
		current += step
		if (current > to) current = from
		func(current)
	}
}

class AngleAnimation(timeout: Int, func: Float => Unit) extends LinearAnimation(0, (2*Pi).toFloat, 0.1f, timeout, func)
