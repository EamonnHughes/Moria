package moria

import processing.core._
import processing.event.MouseEvent

import scala.util.Random

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
    World.enemies.foreach(enemy => enemy.randMov(roomIsIn(enemy)))

    Update(.2f)

  }

  def Update(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime - time > tTime * 1000) {
      time = currentTime
      if (navigateObject(World.player) || doneNothing || doAttack) {
        World.enemies.foreach(enemy => navigateObject(enemy))
        doneNothing = false
        doAttack = false
      }

    }
    checkForDead()
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

  def navigateObject(nObj: NavigatingObject): Boolean = {

    var movX = math.signum(nObj.dst.x - nObj.loc.x)
    var movY = math.signum(nObj.dst.y - nObj.loc.y)

    var newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)

    if (World.findThing(newLoc) == null || newLoc == nObj.loc) {
      nObj.loc = newLoc
    } else {
      doAttack = true
      dealDamage(World.player, World.enemies(nextFoe(nObj, newLoc)))
      newLoc = nObj.loc
    }

    movX != 0 || movY != 0
  }

  def roomIsIn(nObj: NavigatingObject): Int = {
    var roomNum = 0
    for (i <- 0 until World.rooms.length) {
      var rRoom = World.rooms(i)
      if (rRoom.isInside(nObj.loc.x, nObj.loc.y)) {
        roomNum = i
      }

    }
    roomNum
  }
  def nextFoe(nObj: NavigatingObject, newLoc: Location): Int = {
    var enNum = 0
    for (i <- 0 until World.enemies.length) {
      var eEnemy = World.enemies(i)
      if (eEnemy.loc == newLoc) {
        enNum = i
      }

    }
    var foeNum = enNum
    foeNum
  }
  def dealDamage(
      attacker: NavigatingObject with DealsDamage,
      defender: NavigatingObject with HasHealth
  ): Unit = {
    var rToHit = Random.nextInt(100) - attacker.toHitMod
    println(rToHit)
    if (rToHit <= defender.ac) {
      defender.health -= attacker.damageDealt
      println(defender.health)
    }
  }
  def checkForDead(): Unit = {

    World.enemies = World.enemies.filter(enemy => enemy.health > 0)

  }

}

object Moria extends App {

  PApplet.main(classOf[Moria])
}
