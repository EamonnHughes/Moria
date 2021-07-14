package moria

import moria.maprenderer._
import processing.core._

class Moria extends PApplet {

  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {
    rect(mazeenterx, mazeentery, 80, 80)
    rect(mr1x, mr1y, 40, 40)
    line(mazeenterx, mazeentery, mr1x, mr1y)

  }
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
  println("You lose.")
  println("loser")
}
