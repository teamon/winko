package com.yayetee.winko.engine

import TUIO.TuioObject
import com.yayetee.winko.gui.{ProcessingEntity}

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:52:19
 */

abstract class Entity(val tobj: TuioObject) extends Callbacks with ProcessingEntity {
	def x = (tobj.getX * Engine.resolution.width).toInt

	def y = (tobj.getY * Engine.resolution.height).toInt

	def angle = tobj.getAngle

	// callbacks

	registerCallback("oncreate", () => { Logger.debug("Entity {0} created ({1}, {2}, {3})", this.getClass, x, y, angle) })

	registerCallback("onupdate", () => { Logger.debug("Entity {0} updated ({1}, {2}, {3})", this.getClass, x, y, angle) })

	registerCallback("onremove", () => { Logger.debug("Entity {0} removed ({1}, {2}, {3})", this.getClass, x, y, angle) })

}

