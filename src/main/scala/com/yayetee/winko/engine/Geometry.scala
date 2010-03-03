package com.yayetee.winko.engine

/**
 * User: teamon
 * Date: 2010-03-03
 * Time: 22:50:37
 */

object Geometry {
	class Point(val x: Int, val y: Int)

//	class Line(val a: Double, val b: Double) {
//		def y(x: Double) = a * x + b
//	}

	class Rectangle(val x: Int, val y: Int, val width: Int, val height: Int) {
		def contains(p: Point) = p.x >= x && p.x <= x + width && p.y >= y && y <= y + height
	}
}
