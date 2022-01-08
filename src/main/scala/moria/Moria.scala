package moria

import processing.core._
import processing.event.MouseEvent

class Moria extends PApplet {

  var time = System.currentTimeMillis
  val BoardWidth = 1024
  val BoardHeight = 512
  var cPosX = 64.0f
  var cPosY = 64.0f
  var mPosX = cPosX
  var mPosY = cPosY
  var r1 = List(
    Room(16, 32, 512, 256),
    Room(544, 32, 128, 256)
  )
  var l1 = List(
    Hallway(528, 64, 544, 64)
  )
  var e1 = List(Enemy(16, 32), Enemy(64, 32), Enemy(256, 64))

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)
  }

  override def draw(): Unit = {
    background(5, 0, 155)
    fill(255, 255, 255)

    r1.foreach { room =>
      room.draw(this)
    }
    l1.foreach { hall => hall.draw(this) }
    fill(150, 20, 20)
    e1.foreach { enemy => enemy.draw(this) }
    for (i <- 0 until BoardWidth) {
      line((i * 16) - 16, 0, (i * 16) - 16, BoardHeight)
    }
    for (i <- 0 until BoardHeight) {
      line(0, (i * 16) - 16, BoardWidth, (i * 16) - 16)
    }

    fill(255, 255, 0)
    rect(((mouseX / 16).ceil) * 16, ((mouseY / 16).ceil) * 16, 16, 16)

    waitForSeconds(.2f)

    fill(255, 0, 0)
    rect(mPosX, mPosY, 16, 16)

  }

  override def mousePressed(event: MouseEvent): Unit = {
    if (r1.exists(r => r.isInside(event.getX, event.getY))) {
      cPosX = ((event.getX / 16).floor) * 16
      cPosY = ((event.getY / 16).ceil) * 16
    }
  }
  def waitForSeconds(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis
    if (currentTime - time > tTime * 1000) {
      time = currentTime
      println("Tick")
      navigatePlayer()
      e1.foreach(enemy => enemy.RandomMove())
    }
  }
  def navigatePlayer(): Unit = {
    if (cPosX > mPosX && r1.exists(r => r.isInside(mPosX + 16, mPosY))) {
      mPosX += 16
    }
    if (cPosY > mPosY && r1.exists(r => r.isInside(mPosX, mPosY + 16))) {
      mPosY += 16
    }
    if (cPosX < mPosX && r1.exists(r => r.isInside(mPosX - 16, mPosY))) {
      mPosX -= 16
    }
    if (cPosY < mPosY && r1.exists(r => r.isInside(mPosX, mPosY - 16))) {
      mPosY -= 16
    }
  }
}

object Moria extends App {
  PApplet.main(classOf[Moria].getName)
}
