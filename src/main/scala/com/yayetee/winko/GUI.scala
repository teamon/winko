package com.yayetee.winko

import java.awt.event.{WindowAdapter, WindowEvent}
import javax.swing._
import processing.core._
import processing.opengl._
import TUIO.TuioClient

object GUI {
  val WindowWidth = 1024
  val WindowHeight = WindowWidth * 3 / 4
  val BackgroundColor = 51
  var useOpenGL = true
  var applet: PApplet = _
  val frame = new JFrame("winko")
  frame.addWindowListener(new WindowAdapter {
    override def windowClosing(e: WindowEvent) {exit}
  })

  def main(args: Array[String]) {
//    useOpenGL = args.contains("--opengl")
    val client = new TuioClient
    client.addTuioListener(ObjectManager)
    client.connect

    setupWindow
  }

  def setupWindow {
    if(applet != null) applet.destroy
    applet = new MainWindow
    applet.init

//    frame.setUndecorated(true)
    frame.setVisible(false)
    frame.getContentPane.removeAll
    frame.getContentPane.add(applet)
    frame.pack
    frame.setVisible(true)
  }

}

class MainWindow extends PApplet {
  override def setup {
//    if (GUI.useOpenGL)
	    size(1024, 768, PConstants.OPENGL)
//    else size(1024, 768)

    smooth
    noStroke

    rectMode(PConstants.CENTER)
    ellipseMode(PConstants.CENTER)

    textFont(loadFont("QuicksandBook.vlw"));
  }

  override def keyPressed {
    if(key.toString.toLowerCase == "o"){
      println("reload")
      GUI.useOpenGL = !GUI.useOpenGL
      GUI.setupWindow
    }
  }

  override def draw {
    background(GUI.BackgroundColor)

    ObjectManager.objects.foreach(e => {
      pushMatrix
      pushStyle
      translate(e.x, e.y)
      e.paint(this)
      popMatrix
      popStyle
    })

    ObjectManager.cursors.foreach(e => {
      pushMatrix
      pushStyle
      translate(e.x, e.y)
      e.paint(this)
      popMatrix
      popStyle
    })

    ObjectManager.gfxObjects.foreach(e => {
      pushMatrix
      pushStyle
      e.paint(this)
      popMatrix
      popStyle
    })
  }
}
