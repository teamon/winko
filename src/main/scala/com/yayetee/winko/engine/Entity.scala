package com.yayetee.winko.engine

import TUIO.TuioObject

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:52:19
 */

abstract class Entity(val tobj: TuioObject) {
	def x = tobj.getX * Main.resolution.width
	def y = tobj.getY * Main.resolution.height
	def angle = tobj.getAngle

	// callbacks

	def created = Logger.debug("Entity {0} created ({1}, {2}, {3})", this, x, y, angle)
	def updated = Logger.debug("Entity {0} updated ({1}, {2}, {3})", x, y, angle)
	def removed = Logger.debug("Entity {0} removed ({1}, {2}, {3})", x, y, angle)
}

