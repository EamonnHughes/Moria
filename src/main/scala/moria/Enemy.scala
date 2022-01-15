package moria

import processing.core.PApplet

import scala.util.Random

case class Enemy(
    var loc: Location,
    var dst: Location,
    var health: Int,
    var ac: Int,
    var toHitMod: Int,
    var damageDealt: Int
) extends NavigatingObject
    with HasHealth
    with DealsDamage
    with Thing {

  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def randMov(roomNum: Int): Unit = {

    if (loc == dst) {

      dst.x = (Random
        .nextInt(World.rooms(roomNum).lX)) + World
        .rooms(roomNum)
        .posX
      dst.y = (Random
        .nextInt(World.rooms(roomNum).lY)) + World
        .rooms(roomNum)
        .posY

    }
  }

}
