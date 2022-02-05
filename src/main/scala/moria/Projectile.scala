package moria

import processing.core.PApplet

case class Projectile(
    var loc: Location,
    var dst: Location,
    var toHitMod: Int,
    var damageDealt: Int
) extends Thing
    with NavigatingObject
    with DealsDamage {

  def draw(p: PApplet): Unit = {

    val projImg = p.loadImage("src/main/Resources/projectile.png")

    p.fill(255, 0, 255)
    p.image(projImg, loc.x * 16, loc.y * 16, 16, 16)
  }
}
