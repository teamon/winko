package com.yayetee.winko

import Math._

object Geometry {
  def solveCircleLine(a: TObject, b: TObject, R: Double) = {
    val p = (b.y - a.y) / (b.x - a.x)
    val line = new Line(p, -p * a.x + a.y)
    val q = new Quadratic(pow(line.a, 2) + 1, 2 * (line.a * (line.b - a.y) - a.x), pow(a.x, 2) + pow(line.b - a.y, 2) - pow(R, 2))
    val y1 = line.y(q.x1)
    val y2 = line.y(q.x2)
    if (sqrt(pow(q.x1 - b.x, 2) + pow(y1 - b.y, 2)) < sqrt(pow(q.x2 - b.x, 2) + pow(y2 - b.y, 2))) {
      new Point(q.x1, y1)
    } else {
      new Point(q.x2, y2)
    }
  }

  class Point(val x: Double, val y: Double)
  class Line(val a: Double, val b: Double) {
    def y(x: Double) = a * x + b
  }
  class Quadratic(val a: Double, val b: Double, val c: Double) {
    val delta = pow(b, 2) - 4 * a * c
    val x1 = (-b - sqrt(delta)) / (2 * a)
    val x2 = (-b + sqrt(delta)) / (2 * a)
  }
}

