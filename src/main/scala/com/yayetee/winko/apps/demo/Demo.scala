package com.yayetee.winko.apps.demo

import com.yayetee.winko.engine._
import TUIO.TuioObject
import processing.core.PApplet
import com.yayetee.winko.gui.ProcessingEntity

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
		case 1 => new Fader(tobj)
		case _ => new Circle(tobj)
	}

}


class Circle(tobj: TuioObject) extends Entity(tobj) with ProcessingEntity {
	var animAngle = 0f
	var diameter = 0f

	registerCallback("oncreate", () => {
		animate(new AngleAnimation(50, (v) => animAngle = v))
		animate(new FloatAnimation(0f, 400f, 2f, 10, (v) => diameter = v))
	})


	override def draw(p: PApplet) {
		p.translate(x, y)

		p.noStroke
		p.rotate(animAngle)
		p.fill(255, 0, 0)
		p.ellipse(40, 40, 20, 20)

		p.fill(0, 0, 0, 0)
		p.stroke(255)
		p.strokeWeight(5f)
		p.ellipse(0, 0, diameter, diameter)

		p.noStroke
		p.fill(255, 0, 0)
		p.ellipse(0, 0, 40, 40)
	}
}
