package moria

import processing.core._
import processing.event.MouseEvent

class Moria extends PApplet {

  var time = System.currentTimeMillis
  val BoardWidth = 1024
  val BoardHeight = 512
  var doneNothing = false
  var doAttack = false

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
    rect(((mouseX / 16).ceil) * 16, ((mouseY / 16).ceil) * 16, 16, 16)

    Update(.2f)

  }

  def Update(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime - time > tTime * 1000) {
      time = currentTime
      if (navigateObject(World.player) || doneNothing || doAttack) {
        World.enemies.foreach(enemy => enemy.chooseState())
        doneNothing = false
        doAttack = false
        World.enemies.foreach(enemy => navigateObject(enemy))
      }

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

  def navigateObject(nObj: NavigatingObject with DealsDamage): Boolean = {

    var movX = math.signum(nObj.dst.x - nObj.loc.x)
    var movY = math.signum(nObj.dst.y - nObj.loc.y)

    var newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)

    if (World.findThing(newLoc) == null || newLoc == nObj.loc) {
      nObj.loc = newLoc
    } else {
      World.findThing(newLoc) match {
        case hh: NavigatingObject with HasHealth =>
          Combat.dealDamage(nObj, hh)
          if (nObj == Player) { doAttack = true }
        case _ =>
      }

      newLoc = nObj.loc
    }

    movX != 0 || movY != 0
  }

}

object Moria extends App {

  PApplet.main(classOf[Moria])
}
