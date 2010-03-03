package com.yayetee.winko.engine

import TUIO.TuioObject

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:52:19
 */

abstract class Entity(val tobj: TuioObject) extends Callbacks with Animations {
	def x = (tobj.getX * Engine.resolution.width).toInt

	def y = (tobj.getY * Engine.resolution.height).toInt

	def angle = tobj.getAngle

	def rotationSpeed = tobj.getRotationSpeed

	// callbacks

	registerCallback("oncreate", () => { Logger.debug("Entity %s created (%s, %s, %s)", this.getClass, x, y, angle) })

	registerCallback("onupdate", () => { Logger.debug("Entity %s updated (%s, %s, %s)", this.getClass, x, y, angle) })

	registerCallback("onremove", () => { Logger.debug("Entity %s removed (%s, %s, %s)", this.getClass, x, y, angle) })

}

