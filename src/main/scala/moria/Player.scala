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

    val pImg = p.loadImage("src/main/Resources/Crappyperson.png")

    p.fill(0, 255, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
    p.image(pImg, loc.x * 16, loc.y * 16, 16, 16)

    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * health) / maxHealth,
      0,
      50
    )
    p.rect(loc.x * 16, loc.y * 16, 16 * health / maxHealth, 4)
    p.fill(
      255 * (maxHealth - health) / maxHealth,
      (255 * health) / maxHealth,
      0
    )
    p.rect(0, 512, 16, -(64 * health / maxHealth))
    p.fill(255, 255, 0)
    p.textSize(12.0f)
    p.text(health, 0, 496)
  }
  def pClick(posX: Int, posY: Int): Unit = {
    if (World.rooms.exists(r => r.isInside(posX, posY))) {
      if (World.findThing(Location(posX, posY)) == null) {
        dst = Location((posX / 16).floor.toInt, (posY / 16).ceil.toInt)
      }
    }
  }

  def pressKey(keyCode: Int): Unit = {
    if (keyCode == UP) { dst = Location(loc.x, loc.y - 1) }
    if (keyCode == DOWN) { dst = Location(loc.x, loc.y + 1) }
    if (keyCode == LEFT) { dst = Location(loc.x - 1, loc.y) }
    if (keyCode == RIGHT) { dst = Location(loc.x + 1, loc.y) }
  }
  def checkForDead(): Unit = {
    if (health <= 0) {
      //System.exit(0)
    }
  }

}
