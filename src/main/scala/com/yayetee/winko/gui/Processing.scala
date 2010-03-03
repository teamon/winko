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
	var useOpenGL = true
	val frame = new JFrame("winko")
	
	def init {
		frame.addWindowListener(new WindowAdapter {
			override def windowClosing(e: WindowEvent) {System.exit(0)}
		})
		
		setupApplet
	}

	def setupApplet {
		val applet = new MainWindow
		applet.init
		frame.setVisible(false)
		frame.getContentPane.removeAll
		frame.getContentPane.add(applet)
		frame.pack
		frame.setVisible(true)
	}

	def switchOpenGL {
		useOpenGL = !useOpenGL
		setupApplet
	}
}

trait ProcessingEntity {
	def draw(p: PApplet)
}


class MainWindow extends PApplet {
	override def setup {
		if(Processing.useOpenGL) size(Engine.resolution.width, Engine.resolution.height, PConstants.OPENGL)
		else size(Engine.resolution.width, Engine.resolution.height)

		smooth
		noStroke

		rectMode(PConstants.CENTER)
		ellipseMode(PConstants.CENTER)

		textFont(loadFont("QuicksandBook.vlw"))

		frameRate(200)
	}

	override def keyPressed {
		key.toString.toLowerCase match {
			case "o" => Processing.switchOpenGL
			case "q" => exit
			case _ => ()
		}
  }

	override def draw {
		background(51)

		Manager.entities.foreach(e => {
			pushMatrix
			pushStyle
			e.asInstanceOf[ProcessingEntity].draw(this)
			popMatrix
			popStyle
		})

		// info
		textSize(15)
    text("fps = " + frameRate.toInt, 20, 20)
    text("OpenGL:  " + Processing.useOpenGL, 100, 20)
		text("[O]penGL   |   [Q]uit", 250, 20)
	}
}
