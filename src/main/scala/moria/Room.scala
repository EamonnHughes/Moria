package moria

import processing.core._

case class Room(posX: Int, posY: Int, lX: Int, lY: Int) {
  def drawRoom(p: PApplet): Unit = {
    p.rect(posX, posY, lX, lY)

  }
  def isInside(x: Float, y: Float): Boolean = {
    x > posX &&
    x < posX + lX &&
    y > posY &&
    y < posY + lY
  }

}
