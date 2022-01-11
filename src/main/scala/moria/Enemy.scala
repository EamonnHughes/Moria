package moria

import processing.core.PApplet

case class Enemy(
    var posX: Float,
    var posY: Float,
    var goX: Float,
    var goY: Float
) extends NavigatingObject {

  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256)
  )

  def draw(p: PApplet): Unit = {
    p.rect(posX, posY, 16, 16)
  }
  def Patrol(): Unit = {}
  def followPlayer(): Unit = {}
  def randMov(): Unit = {
    if (posX == goX && posY == goY) {
      goX = 0
      goY = 0

    }
  }

}
