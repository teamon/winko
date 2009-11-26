package com.yayetee.winko

import processing.core.PApplet
import TUIO.TuioObject
import Math._

class Fader(tobj: TuioObject) extends TObject(tobj) {
  val e = 0.26
  var realAngle = 0.0
  var previousRotationSpeed = 0.0
  var angleDiff = 0.0

  override def update {
    closeObjects(400).foreach(e => {
      if (4 until 8 contains e.tobj.getSymbolID)
        ObjectManager.addGfxObject(new SineWave(this, e, 400))
    })


    if (tobj.getRotationSpeed == 0) return

    if (tobj.getRotationSpeed * previousRotationSpeed < 0) { // zmiana kierunku
      if (state != 0) angleDiff = 2 * Pi - angle
    } else {
      if (tobj.getRotationSpeed > 0 && state == 1) { // rosnie
        realAngle = 2 * Pi
      } else if (tobj.getRotationSpeed < 0 && state == -1) { // maleje
        realAngle = 0
      } else {
        realAngle = (angle + angleDiff)
      }
    }

    if (realAngle > 2 * Pi) realAngle -= 2 * Pi
    previousRotationSpeed = tobj.getRotationSpeed


  }

  def level = (100 * realAngle / (2 * Pi)).toInt

  def state = if (realAngle + e > 2 * Pi) 1 else if (realAngle - e < 0) -1 else 0

  def paint(p: PApplet) {
    p.noStroke
    p.fill(255, 255, 255, 100)
    p.ellipse(0, 0, 60, 60)
    p.fill(255, 255)
    p.arc(0, 0, 60, 60, 0, realAngle.toFloat)
    p.fill(GUI.BackgroundColor)
    p.ellipse(0, 0, 40, 40)
    p.fill(200)
    p.textSize(15)
    p.text(level.toString + "%", 30, 30)
  }


}
