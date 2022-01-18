package moria

import processing.core.PApplet

import scala.util.Random

case class Enemy(
    var loc: Location,
    var dst: Location,
    var health: Int,
    var ac: Int,
    var toHitMod: Int,
    var damageDealt: Int,
    var maxHealth: Int
) extends NavigatingObject
    with HasHealth
    with DealsDamage
    with Thing {

  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * (health)) / maxHealth,
      0
    )
    p.rect(loc.x * 16, loc.y * 16, 16 * health / maxHealth, 4)

  }
  def chooseState(): Unit = {
    //  if (
    //  (World.player.loc.x > loc.x + 6 || World.player.loc.x < loc.x - 6) && (World.player.loc.y > loc.y + 6 || World.player.loc.y < loc.y - 6)
    //) {
    randMov(World.roomIsIn(this))
    println("Random Movement")
    //} else if (
    (World.player.loc.x <= loc.x + 6 || World.player.loc.x >= loc.x - 6) &&
    (World.player.loc.y <= loc.y + 6 || World.player.loc.y >= loc.y - 6) &&
    ((World.player.loc.x != loc.x + 1 && World.player.loc.x != loc.x - 1 && World.player.loc.x != loc.x) &&
    (World.player.loc.y != loc.y + 1 && World.player.loc.y != loc.y - 1 && World.player.loc.y != loc.y))
    //) {
    //followPlayer()
    //println("Following Player")
    //} else if (
    // (World.player.loc.x == loc.x + 1 || World.player.loc.x == loc.x - 1 || World.player.loc.x == loc.x) &&
    //(World.player.loc.y == loc.y + 1 || World.player.loc.y == loc.y - 1 || World.player.loc.y == loc.y)
    //) {
    //attackPlayer()
    //println("Attacking Player")
    //}
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = { dst = World.player.loc }
  def attackPlayer(): Unit = { dst = World.player.loc }
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
