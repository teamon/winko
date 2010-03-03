package com.yayetee.winko.apps.demo

import com.yayetee.winko.engine.Geometry.{Point, Rectangle}
import com.yayetee.winko.engine.Entity
import com.yayetee.winko.gui.ProcessingEntity
import TUIO.TuioObject
import processing.core.{PConstants, PApplet}

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 22:40:37
 */

class Piano(tobj: TuioObject) extends Entity(tobj) with ProcessingEntity {
	def octave(n: Int) = new LeftWhiteKey(1, n, 0) ::
					new BlackKey(2, n, 1) ::
					new CenterWhiteKey(3, n, 1) ::
					new BlackKey(4, n, 2) ::
					new RightWhiteKey(5, n, 2) ::
					new LeftWhiteKey(6, n, 3) ::
					new BlackKey(7, n, 4) ::
					new CenterWhiteKey(8, n, 4) ::
					new BlackKey(9, n, 5) ::
					new CenterWhiteKey(10, n, 5) ::
					new BlackKey(11, n, 6) ::
					new RightWhiteKey(12, n, 6) :: Nil

	val keys = octave(0)


	override def draw(p: PApplet) {
		p.translate(x,y)
		p.noStroke
    p.rotate(angle - (angle % (Math.Pi/4)).toFloat)
    p.fill(0, 0, 255)
    p.ellipse(0, 0, 40, 40)

    p.stroke(0)
    p.translate(-150, 50)

    p.rectMode(PConstants.CORNER)

    keys.foreach(_.draw(p))

    p.noStroke
    p.rectMode(PConstants.CENTER)
	}
}


abstract class Key(val sign: Int, val octave: Int, val x: Int) {
	final val WHITE_WIDTH = 40
	final val WHITE_HEIGHT = 200
	final val BLACK_WIDTH = 20
	final val BLACK_HEIGHT = 100

	def boundingRectangles = List[Rectangle]()

	def contains(p: Point): Boolean = boundingRectangles.exists(_.contains(p))

	def draw(p: PApplet)
}

class LeftWhiteKey(sign: Int, octave: Int, x: Int) extends Key(sign, octave, x) {
	override def boundingRectangles =
		new Rectangle(x * WHITE_WIDTH, 0, WHITE_WIDTH - BLACK_WIDTH / 2, BLACK_HEIGHT+1) ::
						new Rectangle(x * WHITE_WIDTH, BLACK_HEIGHT, WHITE_WIDTH, WHITE_HEIGHT - BLACK_HEIGHT) :: Nil

	override def draw(p: PApplet) {
		p.fill(255)
		boundingRectangles.foreach(r => p.rect(r.x, r.y, r.width, r.height))
	}
}
class CenterWhiteKey(sign: Int, octave: Int, x: Int) extends Key(sign, octave, x) {
	override def boundingRectangles =
		new Rectangle(x * WHITE_WIDTH + BLACK_WIDTH / 2, 0, WHITE_WIDTH - BLACK_WIDTH, BLACK_HEIGHT+1) ::
						new Rectangle(x * WHITE_WIDTH, BLACK_HEIGHT, WHITE_WIDTH, WHITE_HEIGHT - BLACK_HEIGHT) :: Nil

	override def draw(p: PApplet) {
		p.fill(255)
		boundingRectangles.foreach(r => p.rect(r.x, r.y, r.width, r.height))
	}
}
class RightWhiteKey(sign: Int, octave: Int, x: Int) extends Key(sign, octave, x) {
	override def boundingRectangles =
		new Rectangle(x * WHITE_WIDTH + BLACK_WIDTH / 2, 0, WHITE_WIDTH - BLACK_WIDTH / 2, BLACK_HEIGHT+1) ::
						new Rectangle(x * WHITE_WIDTH, BLACK_HEIGHT, WHITE_WIDTH, WHITE_HEIGHT - BLACK_HEIGHT) :: Nil

	override def draw(p: PApplet) {
		p.fill(255)
		boundingRectangles.foreach(r => p.rect(r.x, r.y, r.width, r.height))
	}
}
class BlackKey(sign: Int, octave: Int, x: Int) extends Key(sign, octave, x) {
	override def boundingRectangles =
		new Rectangle(x * WHITE_WIDTH - BLACK_WIDTH / 2, 0, BLACK_WIDTH, BLACK_HEIGHT) :: Nil

	override def draw(p: PApplet) {
		p.fill(0)
		boundingRectangles.foreach(r => p.rect(r.x, r.y, r.width, r.height))
	}
}
