///**
// * Created by IntelliJ IDEA.
// * User: teamon
// * Date: 2009-11-07
// * Time: 16:00:05
// */
//
//import com.trolltech.qt.core._
//import com.trolltech.qt.gui._
//import TUIO.TuioObject
//
//class SampleObject(tobj: TuioObject) extends PPObject(tobj) {
//  def paint(painter: QPainter) {}
//
//}
//
//
////class SampleObjectGraphicsItem(owner: PPObject) extends WnkObjectGraphicsItem(owner) {
//////  val timer = new QTimeLine(2000)
//////  timer.setFrameRange(0, 100)
//////  timer.setLoopCount(10000)
//////  timer.setUpdateInterval(4)
//////
//////  val animation = new QGraphicsItemAnimation
//////  animation.setItem(this)
//////  animation.setTimeLine(timer)
//////
//////  animation.setScaleAt(0.5, 2, 2)
//////  animation.setScaleAt(1, 1, 1)
//////
//////  timer.start
////
////
////  def paint(painter: QPainter, option: QStyleOptionGraphicsItem, widget: QWidget) {
////    painter.setPen(new QColor(0, 0, 0, 0))
//////    painter.setBrush(new QColor(0, 0, 255))
//////    painter.drawPie(left, top, size, size, 0, owner.angle * 16)
////    painter.setBrush(new QColor(0, 0, 255, 100))
////    painter.drawEllipse(WRect(0.2, 0.6))
////
////    painter.setPen(new QPen(new QColor(0, 0, 0), 5))
////    PPObjectManager.findNear(owner, 600)(_ != owner && owner.tobj.getSessionID == 0).foreach(e => {
////      val a = (e.x - owner.x).toDouble
////      val b = (e.y - owner.y).toDouble
////      var x = 50 / Math.sqrt(1 + Math.pow(b/a, 2))
////      var y = x * b / a
////
////      if(Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2)) > Math.sqrt(Math.pow(-x - a, 2) + Math.pow(-y - b, 2))) {
////        x *= -1
////        y *= -1
////      }
////
////      printf("(%f, %f, %f, %f)\n", a, b, x, y)
//////      painter.drawRect(x.toInt, y.toInt, 5, 5)
////
//////      painter.drawLine(x.toInt, 0, a.toInt, b.toInt)
////      painter.drawLine(new QLineF(x, y, a, b))
////    })
////
////  }
////}
