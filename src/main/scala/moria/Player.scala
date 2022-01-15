package moria

import processing.core.PApplet
import processing.core.PConstants._

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
    with DealsDamage
    with Thing {
  def draw(p: PApplet): Unit = {
    p.fill(0, 255, 0)
    p.rect(posX * 16, posY * 16, 16, 16)
  }

  def pClick(posX: Int, posY: Int): Unit = {
    if (World.rooms.exists(r => r.isInside(posX, posY))) {
      goX = ((posX / 16).floor)
      goY = ((posY / 16).ceil)
    }

  }

  def pressKey(keyCode: Int): Unit = {
    if (keyCode == UP) { goX = posX; goY = posY - 1 }
    if (keyCode == DOWN) { goX = posX; goY = posY + 1 }
    if (keyCode == LEFT) { goX = posX - 1; goY = posY }
    if (keyCode == RIGHT) { goX = posX + 1; goY = posY }
  }

}
