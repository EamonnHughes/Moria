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
    var rRoom = r1(Random.nextInt(r1.length))
    if (posX == goX && posY == goY) {

      goX = (Random.nextInt(rRoom.lX / 16) * 16) + rRoom.posX
      goY = (Random.nextInt(rRoom.lY / 16) * 16) + rRoom.posY

    }
  }

}
