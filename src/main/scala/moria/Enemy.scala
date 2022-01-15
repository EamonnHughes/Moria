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

  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(posX * 16, posY * 16, 16, 16)
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def randMov(roomNum: Int): Unit = {

    if (posX == goX && posY == goY) {

      goX = (Random
        .nextInt(Moria.moria.r1(roomNum).lX)) + Moria.moria
        .r1(roomNum)
        .posX
      goY = (Random
        .nextInt(Moria.moria.r1(roomNum).lY)) + Moria.moria
        .r1(roomNum)
        .posY

    }
  }

}
