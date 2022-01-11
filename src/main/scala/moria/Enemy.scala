package moria

import processing.core.PApplet

import scala.util.Random

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
  def RandomMove(): Unit = {
    var posX = Random.nextInt(64) * 16
    var posY = Random.nextInt(32) * 16

  }
  def Navigate(goPosX: Int, goPosY: Int): Unit = {}

}
