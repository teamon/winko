package com.yayetee.winko.engine

import TUIO.TuioObject
import com.yayetee.winko.gui.{ProcessingEntity}

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:52:19
 */

abstract class Entity(val tobj: TuioObject) extends ProcessingEntity {
	def x = (tobj.getX * Engine.resolution.width).toInt

	def y = (tobj.getY * Engine.resolution.height).toInt

	def angle = tobj.getAngle

	// callbacks

	def created = Logger.debug("Entity {0} created ({1}, {2}, {3})", this.getClass, x, y, angle)

	def updated = Logger.debug("Entity {0} updated ({1}, {2}, {3})", this.getClass, x, y, angle)

	def removed = Logger.debug("Entity {0} removed ({1}, {2}, {3})", this.getClass, x, y, angle)


}

