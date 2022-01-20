package moria

import processing.core._
import processing.event.MouseEvent

class Moria extends PApplet {

  var time: Long = System.currentTimeMillis
  val BoardWidth = 1024
  val BoardHeight = 512
  var doneNothing = false

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {
    background(100, 100, 100)
    fill(255, 255, 255)

    World.rooms.foreach { room =>
      room.draw(this)
    }

    World.enemies.foreach { enemy => enemy.draw(this) }
    World.player.draw(this)
    for (i <- 0 until BoardWidth) {
      line((i * 16) - 16, 0, (i * 16) - 16, BoardHeight)
    }
    for (i <- 0 until BoardHeight) {
      line(0, (i * 16) - 16, BoardWidth, (i * 16) - 16)
    }

    fill(255, 255, 0, 75)
    rect((mouseX / 16.ceil) * 16, (mouseY / 16).ceil * 16, 16, 16)

    Update(.2f)

  }

  def Update(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime - time > tTime * 1000) {

      if (
        Navigation.navigateObject(
          World.player
        ) || doneNothing
      ) {
        World.enemies.foreach(enemy => enemy.chooseState())

        World.enemies.foreach(enemy => Navigation.navigateObject(enemy))

      }
      time = currentTime
      doneNothing = false
      Navigation.doAttack = false
    }

    World.checkForDead()
    World.player.checkForDead()

  }

  override def mousePressed(event: MouseEvent): Unit = {
    World.player.pClick(mouseX, mouseY)
  }

  override def keyPressed(): Unit = {
    World.player.pressKey(keyCode)
    if (key == ' ') {
      doneNothing = true
    }
  }

}

object Moria extends App {

  PApplet.main(classOf[Moria])
}
