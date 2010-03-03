package com.yayetee.winko.apps.demo

import com.yayetee.winko.engine._
import TUIO.TuioObject
import processing.core.PApplet
import actors.Actor
import Math.Pi

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 15:37:44
 */

/**
 * Basic demo application
 *
 * NOTE: Uses Processing GUI
 */

object Demo extends Application {
	def createObject(tobj: TuioObject): Entity = tobj.getSymbolID match {
		case _ => new Circle(tobj)
	}

}


class Circle(tobj: TuioObject) extends Entity(tobj) {
	var animAngle = 0f

	override def created {
//		new Animation(0f, (2 * Pi).toFloat, 0.1f, animAngle = _)
	}

	override def draw(p: PApplet) {
		p.translate(x, y)


		p.noStroke
		p.rotate(animAngle)
		p.fill(255, 0, 0)
		p.ellipse(40, 40, 20, 20)

		p.fill(0, 0, 0, 0)
		p.stroke(255)
		p.strokeWeight(5f)
		//    p.ellipse(0, 0, i+5, i+5)
		//
		//    i+= 2
		//    if(i > 400) i = 0
		//    a += 0.1f
		//    if(a > 2*Pi) a = 0;

		p.noStroke
		p.fill(255, 0, 0)
		p.ellipse(0, 0, 40, 40)
	}
}
