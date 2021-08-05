//in the grim darkness of a galaxy a long time ago the sardaukar forged nine magical shard blades in the depths of the uss enterprise.
package moria

import processing.core._

class Moria extends PApplet {
  val BoardWidth = 80
  val BoardHeight = 60
  val RectSize = 10

  override def settings(): Unit = {
    size(BoardWidth * RectSize, BoardHeight * RectSize)
  }

  override def draw(): Unit = {

    for (i <- 0 to BoardHeight) {
      rectline(i)
    }
    rect()
  }
  def rectline(y: Int): Unit = {
    for (i <- 0 to BoardWidth) {
      rect(i * RectSize, y * RectSize, RectSize, RectSize)
    }
  }
  def connectLine(
      x1: Int,
      x2: Int,
      y1: Int,
      y2: Int,
      xl1: Int,
      xl2: Int,
      yl1: Int,
      yl2: Int
  ): Unit = {
    var xf1: Int = x1
    var xf2: Int = x2
    var yf1: Int = y1
    var yf2: Int = y2
    if (x1 > x2) {
      xf2 = x2 + xl2
    } else if (x1 < x2) {
      xf1 = x1 + xl1
    } else {
      xf1 = x1 + (xl1 / 2)
      xf2 = x2 + (xl2 / 2)
    }
    if (y1 > y2) {

      yf2 = y2 + yl2
    } else if (y1 < y2) {
      yf1 = y1 + yl1
    }

    line(xf1, yf1, xf2, yf2)

  }
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
}
