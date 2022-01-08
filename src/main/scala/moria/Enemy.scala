package moria

import processing.core.PApplet

import scala.util.Random

case class Enemy(posX: Int, posY: Int) {

  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256)
  )

  def draw(p: PApplet): Unit = {
    p.rect(posX, posY, 16, 16)
  }
  def RandomMove(): Unit = {
    var posX = Random.nextInt(1024)
    var posY = Random.nextInt(512)

  }
  def Navigate(goPosX: Int, goPosY: Int): Unit = {}

}
