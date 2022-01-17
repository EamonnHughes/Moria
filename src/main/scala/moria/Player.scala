package moria
import processing.core.PConstants._
import processing.core._

case class Player(
    var loc: Location,
    var dst: Location,
    var health: Int,
    var ac: Int,
    var toHitMod: Int,
    var damageDealt: Int,
    var maxHealth: Int
) extends NavigatingObject
    with HasHealth
    with DealsDamage {
  def draw(p: PApplet): Unit = {

    p.fill(0, 255, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * (health)) / maxHealth,
      0
    )
    p.rect(loc.x * 16, loc.y * 16, 16 * health / maxHealth, 4)
    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * (health)) / maxHealth,
      0
    )
    p.rect(0, 512, 16, -(64 * health / maxHealth))
    p.fill(255, 255, 0)
    p.textSize(12.0f)
    p.text(health, 0, 496)
  }

  def pClick(posX: Int, posY: Int): Unit = {
    if (World.rooms.exists(r => r.isInside(posX, posY))) {
      dst.x = ((posX / 16).floor.toInt)
      dst.y = ((posY / 16).ceil.toInt)
    }

  }

  def pressKey(keyCode: Int): Unit = {
    if (keyCode == UP) { dst.x = loc.x; dst.y = loc.y - 1 }
    if (keyCode == DOWN) { dst.x = loc.x; dst.y = loc.y + 1 }
    if (keyCode == LEFT) { dst.x = loc.x - 1; dst.y = loc.y }
    if (keyCode == RIGHT) { dst.x = loc.x + 1; dst.y = loc.y }
  }
  def checkForDead(): Unit = {
    if (health <= 0) {
      System.exit(0)
    }
  }

}
