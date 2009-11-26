package com.yayetee.winko

import java.awt.event.{WindowAdapter, WindowEvent}
import javax.swing._
import processing.core._
import processing.opengl._
import TUIO.TuioClient

object GUI extends Application {
  val WindowWidth = 1024
  val WindowHeight = WindowWidth * 3 / 4
  val BackgroundColor = 51

  val frame = new JFrame("winko")
  val applet = new MainWindow
  frame.getContentPane.add(applet)
  frame.addWindowListener(new WindowAdapter {
    override def windowClosing(e: WindowEvent) {exit}
  })
  applet.init
  frame.pack
  frame.setVisible(true)

  val client = new TuioClient
  client.addTuioListener(ObjectManager)
  client.connect


}

class MainWindow(val useOpenGL: Boolean) extends PApplet {
  def this() = this(true)
  
  override def setup {
    //if(useOpenGL)
    //  size(1024, 768)
    size(1024, 768, PConstants.OPENGL)
    smooth
    noStroke

    rectMode(PConstants.CENTER)
    ellipseMode(PConstants.CENTER)

   // textFont(loadFont("res/QuicksandBook.vlw"));
  }

  override def draw {
    background(GUI.BackgroundColor)

    ObjectManager.objects.foreach(e => {
      pushMatrix
      translate(e.x, e.y)
      e.paint(this)
      popMatrix
    })

    ObjectManager.gfxObjects.foreach(e => {
      pushMatrix
      e.paint(this)
      popMatrix
    })
  }
}