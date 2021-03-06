package com.yayetee.winko

import processing.core.PApplet
import Math._

class SineWave(val a: TObject, val b: TObject, val distance: Double) extends TGfxObject {
  var strokeWeight = 1f
  var strokeI = 0.03f
  var fi = 0f

  def paint(papplet: PApplet) {
    val p = Geometry.solveCircleLine(a, b, 40)
    val q = Geometry.solveCircleLine(b, a, 40)
    
//    papplet.stroke(255)
//    papplet.strokeWeight(strokeWeight)
//    papplet.line(p.x.toFloat, p.y.toFloat, q.x.toFloat, q.y.toFloat)
//
//    strokeWeight += strokeI
//    if (strokeWeight >= 4 || strokeWeight <= 1) strokeI = -strokeI

    papplet.stroke(255)
    papplet.strokeWeight(3f)

    val length = sqrt(pow(p.x-q.x, 2) + pow(p.y-q.y, 2))
    papplet.translate(p.x.toFloat, p.y.toFloat)
    papplet.rotate(atan((p.y - q.y) / (p.x - q.x)).toFloat)

    val s = (p.x - q.x) / abs(p.x - q.x)

    var i = 0.0
    while(i <= 1){
      papplet.point((-s*length*i).toFloat, 15*sin(4*Pi * i + fi).toFloat)
      i += 0.001
    }

    fi += 0.2f
    if(fi > 2*Pi) fi = 0f
  }

  override def equals(other: Any) = other match {
    case other: SineWave => (a == other.a && b == other.b) || (a == other.b && b == other.a)
    case _ => false
  }

  override def active = !a.removed && !b.removed && a.closeTo(b, distance)

}

