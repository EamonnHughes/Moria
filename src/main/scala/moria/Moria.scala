package moria

import moria.maprenderer._
import processing.core._

class Moria extends PApplet {

  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {
    rect(mazeEnterX, mazeEnterY, entx, enty)
    rect(mr1x, mr1y, r1x, r1y)
    rect(mr2x, mr2y, r1y, r2y)
  }

  def connectLine(): Unit = {
    //connect a line
  }
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
  println("You lose.")
  println("loser")
}
