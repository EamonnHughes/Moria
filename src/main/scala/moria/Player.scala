package moria

import processing.core.PApplet

case class Player(
    var mPosX: Float,
    var mPosY: Float,
    var gPosX: Float,
    var gPosY: Float
) {
  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(mPosX, mPosY, 16, 16)
  }

  def pClick(posX: Int, posY: Int): Unit = {
    if (Moria.moria.r1.exists(r => r.isInside(posX, posY))) {
      gPosX = ((posX / 16).floor) * 16
      gPosY = ((posY / 16).ceil) * 16
    }
  }

  def navigatePlayer(): Unit = {
    if (
      mPosX > gPosX && Moria.moria.r1.exists(r => r.isInside(mPosX - 16, mPosY))
    ) {
      mPosX -= 16
    }
    if (
      mPosY > gPosY && Moria.moria.r1.exists(r => r.isInside(mPosX, mPosY - 16))
    ) {
      mPosY -= 16
    }
    if (
      mPosX < gPosX && Moria.moria.r1.exists(r => r.isInside(mPosX + 16, mPosY))
    ) {
      mPosX += 16
    }
    if (
      mPosY < gPosY && Moria.moria.r1.exists(r => r.isInside(mPosX, mPosY + 16))
    ) {
      mPosY += 16
    }
  }
}
