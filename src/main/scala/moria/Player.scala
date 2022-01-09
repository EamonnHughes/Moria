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
      gPosY = ((posY / 16).ceil)s * 16
    }
  }

}
