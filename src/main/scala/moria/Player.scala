package moria

import processing.core.PApplet

case class Player(
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
    p.fill(0, 255, 0)
    p.rect(posX, posY, 16, 16)
  }

  def pClick(posX: Int, posY: Int): Unit = {
    if (Moria.moria.r1.exists(r => r.isInside(posX, posY))) {
      goX = ((posX / 16).floor) * 16
      goY = ((posY / 16).ceil) * 16
    }

  }

}
