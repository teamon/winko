package com.yayetee.winko.apps.demo

import TUIO.TuioObject
import com.yayetee.winko.gui.ProcessingEntity
import processing.core.PApplet
import Math.Pi
import com.yayetee.winko.engine.{Logger, Entity}

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 21:11:50
 */

class Fader(tobj: TuioObject) extends Entity(tobj) with ProcessingEntity {
  final val e = 0.26
  var realAngle = 0.0
  var previousRotationSpeed = 0.0
  var angleDiff = 0.0

	removeCallbacks("onupdate")
	registerCallback("onupdate", update _)

  def update {
	  Logger.debug("Fader: speed=%s previousSpeed=%s", rotationSpeed, previousRotationSpeed)
    if (rotationSpeed == 0) return

    if (rotationSpeed * previousRotationSpeed < 0) { // change direction
      if (state != 0) angleDiff = 2 * Pi - angle
    } else {
      if (rotationSpeed > 0 && state == 1) { // increese
        realAngle = 2 * Pi
      } else if (rotationSpeed < 0 && state == -1) { // decreese
        realAngle = 0
      } else {
        realAngle = (angle + angleDiff)
      }
    }

    if (realAngle > 2 * Pi) realAngle -= 2 * Pi
    previousRotationSpeed = rotationSpeed

  }

  def level = (100 * realAngle / (2 * Pi)).toInt

  def state = if (realAngle + e > 2 * Pi) 1 else if (realAngle - e < 0) -1 else 0

	
  override def draw(p: PApplet) {
	  p.translate(x, y)
    p.noStroke
    p.fill(255, 255, 255, 100)
    p.ellipse(0, 0, 60, 60)
    p.fill(255, 255)
    p.arc(0, 0, 60, 60, 0, realAngle.toFloat)
    p.fill(51)
    p.ellipse(0, 0, 40, 40)
    p.fill(200)
    p.textSize(15)
    p.text(level.toString + "%", 30, 30)
  }

}
