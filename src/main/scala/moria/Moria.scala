package moria

import processing.core.PApplet

class Moria extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  override def setup(): Unit = {}

  override def settings(): Unit = {
    size(1024, 512)
    noSmooth()
  }

  override def draw(): Unit = {
    background(100, 100, 100)
    World.rooms.foreach(room => room.draw(this))

    World.player.draw(this)
    Tick

  }
  def Tick: Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      tTick = (tTick + 1) % 10
      time = currentTime
      World.player.navTo
      World.player.move

    }

  }
}

object Moria extends App {
  PApplet.main(classOf[Moria])

}
