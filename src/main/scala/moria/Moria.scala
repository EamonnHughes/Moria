package moria

import moria.maprenderer._
import processing.core._

class Moria extends PApplet {
  val BoardWidth = 80
  val BoardHeight = 60
  val RectSize = 10

  override def settings(): Unit = {
    size(BoardWidth * RectSize, BoardHeight * RectSize)
  }

  override def draw(): Unit = {
    rect(mazeEnterX, mazeEnterY, entx, enty)
    rect(mr1x, mr1y, r1x, r1y)
    rect(mr2x, mr2y, r1y, r2y)
    connectLine(mr1x, mr2x, mr1y, mr2y, r1x, r2x, r1y, r2y)
    connectLine(mazeEnterX, mr1x, mazeEnterY, mr1y, entx, r1x, enty, r1y)
    connectLine(mazeEnterX, mr2x, mazeEnterY, mr2y, entx, r2x, enty, r2y)

    for (i <- 0 to BoardWidth) {
      line(
        (i * RectSize) - RectSize,
        0,
        (i * RectSize) - RectSize,
        BoardHeight * 10
      )
    }
    for (i <- 0 to BoardHeight) {
      line(
        0,
        (i * RectSize) - RectSize,
        BoardWidth * RectSize,
        (i * RectSize) - RectSize
      )
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
  println("You lose.")
  println("loser")
}
