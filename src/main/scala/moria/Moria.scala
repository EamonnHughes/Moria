package moria

import processing.core.PApplet

class Moria extends PApplet {

  override def settings(): Unit = {
    size(800, 600)
  }

  override def draw(): Unit = {

    rect(10, 10, 100, 100)
  }
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
  println("You lose.")
}
