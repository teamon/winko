package com.yayetee.winko

import processing.core.PApplet
import TUIO.TuioObject
import Math._

abstract class TObject(var tobj: TuioObject) {
  var removed = false
  def x = tobj.getX * GUI.WindowWidth
  def y = tobj.getY * GUI.WindowHeight
  def angle = tobj.getAngle

  // callbacks
  def create = printf("create %s(%f, %f, %f)\n", this.getClass.toString, x, y, angle)
  def update = printf("update %s(%f, %f, %f)\n", this.getClass.toString, x, y, angle)
  def remove = printf("remove %s(%f, %f, %f)\n", this.getClass.toString, x, y, angle)

  def paint(p: PApplet)

  def closeObjects(distance: Double) = ObjectManager.objects.filter(o => o != this && o.closeTo(this, distance))

  def closeTo(other: TObject, distance: Double) = sqrt(pow(other.x - x, 2) + pow(other.y - y, 2)) <= distance

}


