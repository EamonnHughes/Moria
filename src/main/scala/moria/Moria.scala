package moria
import processing.core._
import processing.event.MouseEvent

class Moria extends PApplet {
  var time: Long = System.currentTimeMillis
  var tTick = 0

  override def setup(): Unit = {

    World.player.loc = World.levelList(0).entrance
  }

  override def settings(): Unit = {
    size(1024, 512)
    noSmooth()
  }

  override def draw(): Unit = {
    background(100, 100, 100)
    World.currentLevel.roomList.foreach(room => room.draw(this))
    World.currentLevel.exit.draw(this)
    World.player.draw(this)
    fill(10, 10, 10)
    rect(0, 512, 16, -World.player.maxHealth * 16)
    fill(255, 0, 0)
    rect(0, 512, 16, -World.player.health * 16)
    Tick

  }

  def Tick: Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime > time + 100) {
      World.currentLevel.exit.nextLevelCheck
      World.currentLevel = World.levelList(World.currentLevelNumber)
      tTick = (tTick + 1) % 10
      time = currentTime
      World.player.navTo
      World.player.move

    }

  }

  override def mousePressed(event: MouseEvent): Unit = {
    val mouseButton = event.getButton
    val mouseX = event.getX
    val mouseY = event.getY
    if (mouseButton == 39) {
      World.player.dst = Location(mouseX / 16, mouseY / 16)

    }
  }
}

object Moria extends App {
  PApplet.main(classOf[Moria])

}
