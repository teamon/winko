package com.yayetee.winko

import TUIO._

object ObjectManager extends TuioListener {
  var objects = List[TObject]()
  var cursors = List[TCursor]()
  var gfxObjects = List[SineWave]()

  def createPPObject(tobj: TuioObject): TObject = {
    println(tobj.getSymbolID)
    tobj.getSymbolID match {
      //case x if 0 until 4 contains x => new Square(tobj)
      case 0 => new Keyboard(tobj)
      case x if 4 until 8 contains x => new Fader(tobj)
      case _ => new Square(tobj)
    }
  }

  def updateGfxObjects = gfxObjects.filter(!_.active).foreach(removeGfxObject(_))

  def addGfxObject(gobj: SineWave) {
    if(ObjectManager.gfxObjects.filter(_ == gobj).size == 0){
      gfxObjects = gobj :: gfxObjects
    }
  }

  def removeGfxObject(gobj: SineWave) {
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

  def addTuioCursor(tcur: TuioCursor) {
    cursors = new TCursor(tcur) :: cursors
  }

  def updateTuioCursor(tcur: TuioCursor) {}

  def removeTuioCursor(tcur: TuioCursor) {
    cursors = cursors.remove(_.tcur == tcur)
  }

  def refresh(frameTime: TuioTime) {}


}
