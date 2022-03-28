package moria

import processing.core._

case class Room(posX: Int, posY: Int, lX: Int, lY: Int) {
  def draw(p: PApplet): Unit = {
    p.noStroke()
    p.rect(posX * 16, posY * 16, lX * 16, lY * 16)

  }
  def isInside(location: Location): Boolean = {
    location.x >= posX * 16 &&
    location.x < (posX + lX) * 16 &&
    location.y >= posY * 16 &&
    location.y < (posY + lY) * 16
  }

}
