package com.yayetee

import TUIO._

object PPObjectManager extends TuioListener {
  var objects = List[PPObject]()
  var gfxObjects = List[PPLine]()

  def createPPObject(tobj: TuioObject): PPObject = {
    tobj.getSymbolID match {
      case x if 0 until 4 contains x => new SquareObject(tobj)
      case x if 4 until 8 contains x => new PPFaderObject(tobj)
      case _ => new SquareObject(tobj)
    }
  }

  def updateGfxObjects = gfxObjects.filter(!_.active).foreach(removeGfxObject(_))

  def addGfxObject(gobj: PPLine) {
    if(PPObjectManager.gfxObjects.filter(_ == gobj).size == 0){
      gfxObjects = gobj :: gfxObjects
    }
  }

  def removeGfxObject(gobj: PPLine) {
    gfxObjects = gfxObjects.remove(_ == gobj)
  }


  // Listeners

  def addTuioObject(tobj: TuioObject) {
    objects = createPPObject(tobj) :: objects
  }

  def updateTuioObject(tobj: TuioObject) {
    objects.find(_.tobj == tobj).foreach(_.update)
    updateGfxObjects
  }

  def removeTuioObject(tobj: TuioObject) {
    objects = objects.remove(e => if(e.tobj == tobj) {
      e.removed = true
      e.remove; true
    } else false)
    updateGfxObjects
  }

  def addTuioCursor(tcur: TuioCursor) {}

  def updateTuioCursor(tcur: TuioCursor) {}

  def removeTuioCursor(tcur: TuioCursor) {}

  def refresh(frameTime: TuioTime) {}


}