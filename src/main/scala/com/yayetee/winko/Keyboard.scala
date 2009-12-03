package com.yayetee.winko

import TUIO.TuioObject
import Math._
import processing.core.{PConstants, PApplet}
import collection.immutable.Map

class Keyboard(tobj: TuioObject) extends TObject(tobj) {
  val keys = new PianoKey(1, 'white_left, 0) ::
          new PianoKey(2, 'black, 0) ::
          new PianoKey(3, 'white_center, 1) ::
          new PianoKey(4, 'black, 1) ::
          new PianoKey(5, 'white_right, 2) ::
          new PianoKey(6, 'white_left, 3) ::
          new PianoKey(7, 'black, 3) ::
          new PianoKey(8, 'white_center, 4) ::
          new PianoKey(9, 'black, 4) ::
          new PianoKey(10, 'white_center, 5) ::
          new PianoKey(11, 'black, 5) ::
          new PianoKey(12, 'white_right, 6) ::
          Nil


  def paint(p: PApplet) {
    p.noStroke
    p.rotate(angle)
    p.fill(255, 0, 0)
    p.ellipse(0, 0, 40, 40)

    //    p.fill(0, 255, 0)
    //    p.rectMode(PConstants.CORNER)
    //    p.rect(100, 100, 100, 100)

    p.stroke(0)

    p.translate(-200, 50)

    p.rectMode(PConstants.CORNER)
    keys.foreach(_.draw(p))
    p.noStroke
    p.rectMode(PConstants.CENTER)
  }                                                                                                                         
}

class PianoKey(val tone: Int, val kind: Symbol, val offsetX: Int) {
  val wWidth = 40
  val wHeight = 200
  val bWidth = 20
  val bHeight = 100

  var pressed = false
  val rectangles = Map(
    'black -> List(
      List((offsetX + 1) * wWidth - bWidth / 2, 0, bWidth, bHeight)
      ),
    'white_left -> List(
      List(offsetX * wWidth, 0, wWidth - bWidth / 2, bHeight),
      List(offsetX * wWidth, bHeight, wWidth, wHeight - bHeight)
      ),
    'white_center -> List(
      List(offsetX * wWidth + wWidth - (wWidth - bWidth / 2), 0, wWidth - bWidth, bHeight),
      List(offsetX * wWidth, bHeight, wWidth, wHeight - bHeight)
      ),
    'white_right -> List(
      List(offsetX * wWidth + wWidth - (wWidth - bWidth / 2), 0, wWidth - bWidth / 2, bHeight),
      List(offsetX * wWidth, bHeight, wWidth, wHeight - bHeight)
      )
    )

  def draw(p: PApplet) {
    if (pressed) {
      p.fill(255, 0, 0)
    } else {
      if (kind == 'black) p.fill(0)
      else p.fill(255)
    }

    rectangles(kind).foreach(drawRect(p, _))
  }

  def drawRect(p: PApplet, rect: List[Int]) {
    p.rect(rect(0), rect(1), rect(2), rect(3))
  }

  def contains(x: Int, y: Int) = {
    pressed = rectangles(kind).exists(r => x >= r(0) && x <= r(2) && y >= r(1) && y <= r(3))
    pressed
  }
}
