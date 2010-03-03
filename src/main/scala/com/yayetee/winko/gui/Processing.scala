package com.yayetee.winko.gui

import processing.core.{PConstants, PApplet}
import java.awt.event.{WindowEvent, WindowAdapter}
import javax.swing.JFrame
import com.yayetee.winko.engine.{Logger, Engine, Manager}

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 14:11:22
 */

/**
 * Basic GUI object that uses Processing API
 */

object Processing {
	val applet = new MainWindow
	val frame = new JFrame("winko")
	
	def init {
		applet.init
		
		frame.addWindowListener(new WindowAdapter {
			override def windowClosing(e: WindowEvent) {System.exit(0)}
		})

		frame.setVisible(false)
		frame.getContentPane.removeAll
		frame.getContentPane.add(applet)
		frame.pack
		frame.setVisible(true)
	}
}

trait ProcessingEntity {
	def draw(p: PApplet)
}


class MainWindow extends PApplet {
	override def setup {
		size(Engine.resolution.width, Engine.resolution.height)

		smooth
		noStroke

		rectMode(PConstants.CENTER)
		ellipseMode(PConstants.CENTER)

		textFont(loadFont("QuicksandBook.vlw"))

		frameRate(200)
	}

	override def draw {
		background(51)

		Manager.entities.foreach(e => {
			pushMatrix
			pushStyle
			e.draw(this)
			popMatrix
			popStyle
		})



		textSize(15)
    text("fps = " + frameRate.toInt, 20, 20)
	}
}
