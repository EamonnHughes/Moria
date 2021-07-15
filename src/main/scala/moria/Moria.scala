package moria

import moria.maprenderer._
import processing.core._

class Moria extends PApplet {

  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {
    rect(mazeEnterX, mazeEnterY, 80, 80)
    rect(mr1x, mr1y, 40, 40)
    rect(mr2x, mr2y, 40, 40)
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
