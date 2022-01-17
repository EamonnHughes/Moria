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
  val maxHealth = health

  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * (health)) / maxHealth,
      0
    )
    p.rect(loc.x * 16, loc.y * 16, 16 * health / maxHealth, -10)
    p.fill(255, 0, 0)
    p.text(health, loc.x * 16, loc.y * 16)

  }
  def chooseState(): Unit = {
    if (
      World.player.loc.x > loc.x + 6 || World.player.loc.x < loc.x - 6 || World.player.loc.y > loc.y + 6 || World.player.loc.y < loc.y - 6
    ) {
      Patrol()
    } else if (
      World.player.loc.x <= loc.x + 6 || World.player.loc.x >= loc.x - 6 || World.player.loc.y <= loc.y + 6 || World.player.loc.y >= loc.y - 6
    ) {
      followPlayer()
    } else if (
      World.player.loc.x == loc.x + 1 || World.player.loc.x == loc.x - 1 || World.player.loc.y == loc.y + 1 || World.player.loc.y == loc.y - 1
    ) {
      attackPlayer()
    }
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def attackPlayer(): Unit = {}
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
