package moria

import processing.core.PApplet

class Moria extends PApplet {
  override def setup(): Unit = {}
  override def settings(): Unit = {
    size(1024, 512)
    noSmooth()
  }
  override def draw(): Unit = {
    background(100, 100, 100)
  }

}
object Moria extends App {
  PApplet.main(classOf[Moria])

}
