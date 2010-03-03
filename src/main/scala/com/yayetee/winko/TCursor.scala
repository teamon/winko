package com.yayetee.winko

import TUIO.TuioCursor
import processing.core.PApplet

class TCursor(var tcur: TuioCursor) extends TGenericObject {
  def x = tcur.getX * GUI.WindowWidth
  def y = tcur.getY * GUI.WindowHeight

  override def paint(p: PApplet){
    p.fill(0, 255, 0)
    p.ellipse(0, 0, 20, 20)
  }
}