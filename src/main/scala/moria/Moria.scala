package moria

import processing.core._

class Moria extends PApplet {
  val BoardWidth = 1024
  val BoardHeight = 512

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {}
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
}
