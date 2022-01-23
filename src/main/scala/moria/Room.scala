package moria

import processing.core._

case class Room(posX: Int, posY: Int, lX: Int, lY: Int) {
  def draw(p: PApplet): Unit = {
    p.noStroke()
    p.rect(posX * 16, posY * 16, lX * 16, lY * 16)

  }
  def isInside(x: Float, y: Float): Boolean = {
    x >= posX * 16 &&
    x < (posX + lX) * 16 &&
    y >= posY * 16 &&
    y < (posY + lY) * 16
  }

}
