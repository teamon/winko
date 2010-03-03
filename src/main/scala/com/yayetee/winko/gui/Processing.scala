package com.yayetee.winko.gui

import processing.core.{PConstants, PApplet}
import java.awt.event.{WindowEvent, WindowAdapter}
import javax.swing.JFrame

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 14:11:22
 */

/**
 * Basic GUI object that uses Processing API
 */

object Processing extends Renderer {
	def init {
		val applet = new MainWindow
		applet.init

		val frame = new JFrame("winko")
		frame.addWindowListener(new WindowAdapter {
			override def windowClosing(e: WindowEvent) { System.exit(0) }
		})

		frame.setVisible(false)
		frame.getContentPane.removeAll
		frame.getContentPane.add(applet)
		frame.pack
		frame.setVisible(true)
	}

	def draw {

	}
}


class MainWindow extends PApplet {
	override def setup {
		size(400, 300, PConstants.OPENGL)

		smooth
		noStroke

		rectMode(PConstants.CENTER)
		ellipseMode(PConstants.CENTER)

		textFont(loadFont("QuicksandBook.vlw"));
	}

	override def draw {
		background(51)

		//    ObjectManager.objects.foreach(e => {
		//      pushMatrix
		//      pushStyle
		//      translate(e.x, e.y)
		//      e.paint(this)
		//      popMatrix
		//      popStyle
		//    })
		//
		//    ObjectManager.cursors.foreach(e => {
		//      pushMatrix
		//      pushStyle
		//      translate(e.x, e.y)
		//      e.paint(this)
		//      popMatrix
		//      popStyle
		//    })
		//
		//    ObjectManager.gfxObjects.foreach(e => {
		//      pushMatrix
		//      pushStyle
		//      e.paint(this)
		//      popMatrix
		//      popStyle
		//    })
	}
}
