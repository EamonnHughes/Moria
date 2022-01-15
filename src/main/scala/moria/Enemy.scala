package moria

import processing.core.PApplet

import scala.util.Random

case class Enemy(
    var posX: Float,
    var posY: Float,
    var goX: Float,
    var goY: Float
) extends NavigatingObject {

  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256)
  )

  def draw(p: PApplet): Unit = {
    p.rect(posX, posY, 16, 16)
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def randMov(): Unit = {
    var roomNum = 0
    for (i <- 0 until r1.length) {
      var rRoom = r1(i)
      if (rRoom.isInside(posX, posY)) {
        roomNum = i

      }

    }
    if (posX == goX && posY == goY) {

      goX = (Random.nextInt(r1(roomNum).lX / 16) * 16) + r1(roomNum).posX
      goY = (Random.nextInt(r1(roomNum).lY / 16) * 16) + r1(roomNum).posY

    }
  }

}
