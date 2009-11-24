package com.yayetee

import processing.core.PApplet
import TUIO.TuioObject
import Math._

class SquareObject(tobj: TuioObject) extends PPObject(tobj) {
  var i = 0
  var a = 0f

  override def update {
    closeObjects(400).foreach(e => {
      if(0 until 4 contains e.tobj.getSymbolID)
        PPObjectManager.addGfxObject(new PPLine(this, e, 400))
    })

  }

  def paint(p: PApplet) {
    p.noStroke
    p.rotate(a)
    p.fill(255, 0, 0)
    p.ellipse(40, 40, 20, 20)
//    p.rect(0, 0, 40, 40)

    p.fill(0, 0, 0, 0)
    p.stroke(255)
    p.strokeWeight(5f)
    p.ellipse(0, 0, i+5, i+5)

    i+= 2
    if(i > 400) i = 0
    a += 0.1f
    if(a > 2*Pi) a = 0;

    p.noStroke
    p.fill(255, 0, 0)
    p.ellipse(0, 0, 40, 40)

  }

}
