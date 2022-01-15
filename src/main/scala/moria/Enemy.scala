package moria

import processing.core.PApplet

import scala.util.Random

case class Enemy(
    var posX: Float,
    var posY: Float,
    var goX: Float,
    var goY: Float,
    var health: Int,
    var ac: Int,
    var toHitMod: Int,
    var damageDealt: Int
) extends NavigatingObject
    with HasHealth
    with DealsDamage {

  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256)
  )

  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(posX, posY, 16, 16)
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def randMov(roomNum: Int): Unit = {

    if (posX == goX && posY == goY) {

      goX = (Random.nextInt(r1(roomNum).lX / 16) * 16) + r1(roomNum).posX
      goY = (Random.nextInt(r1(roomNum).lY / 16) * 16) + r1(roomNum).posY

    }
  }

}
