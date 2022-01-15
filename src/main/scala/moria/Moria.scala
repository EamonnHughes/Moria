package moria

import processing.core._
import processing.event.MouseEvent

class Moria extends PApplet {
  Moria.moria = this
  var time = System.currentTimeMillis
  val BoardWidth = 1024
  val BoardHeight = 512

  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256),
    Room(528, 288, 32, 32)
  )
  var e1 = List(
    Enemy(16, 32, 16, 64),
    Enemy(64, 32, 64, 256),
    Enemy(256, 64, 128, 32)
  )
  var player = Player(64, 64, 64, 64)

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {
    background(100, 100, 100)
    fill(255, 255, 255)

    r1.foreach { room =>
      room.draw(this)
    }

    e1.foreach { enemy => enemy.draw(this) }
    player.draw(this)
    for (i <- 0 until BoardWidth) {
      line((i * 16) - 16, 0, (i * 16) - 16, BoardHeight)
    }
    for (i <- 0 until BoardHeight) {
      line(0, (i * 16) - 16, BoardWidth, (i * 16) - 16)
    }

    fill(255, 255, 0, 75)
    rect(((mouseX / 16).ceil) * 16, ((mouseY / 16).ceil) * 16, 16, 16)
    e1.foreach(enemy => enemy.randMov(roomIsIn(enemy)))

    waitForSeconds(.2f)

  }

  def waitForSeconds(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime - time > tTime * 1000) {
      time = currentTime
      if (navigateObject(player)) {
        e1.foreach(enemy => navigateObject(enemy))
      }

      println("Tick")
    }
  }

  override def mousePressed(event: MouseEvent): Unit = {
    player.pClick(mouseX, mouseY)
  }

  def navigateObject(nObj: NavigatingObject): Boolean = {

    var moved = false
    if (
      nObj.posX < nObj.goX &&
      r1.exists(room => room.isInside(nObj.posX + 16, nObj.posY))
    ) {
      nObj.posX += 16
      moved = true
    }
    if (
      nObj.posY < nObj.goY &&
      r1.exists(room => room.isInside(nObj.posX, nObj.posY + 16))
    ) {
      nObj.posY += 16
      moved = true
    }
    if (
      nObj.posX > nObj.goX &&
      r1.exists(room => room.isInside(nObj.posX - 16, nObj.posY))
    ) {
      nObj.posX -= 16
      moved = true
    }
    if (
      nObj.posY > nObj.goY &&
      r1.exists(room => room.isInside(nObj.posX, nObj.posY - 16))
    ) {
      nObj.posY -= 16
      moved = true
    }
    moved
  }

  def roomIsIn(nObj: NavigatingObject): Int = {
    var roomNum = 0
    for (i <- 0 until r1.length) {
      var rRoom = r1(i)
      if (rRoom.isInside(nObj.posX, nObj.posY)) {
        roomNum = i

      }

    }
    roomNum
  }
  def dealDamage(
      attacker: NavigatingObject,
      defender: NavigatingObject
  ): Unit = {}
}

object Moria extends App {
  var moria: Moria = _

  PApplet.main(classOf[Moria])
}
