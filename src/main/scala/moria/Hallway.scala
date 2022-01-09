package moria

import processing.core._

case class Hallway(SPosX: Int, SPosY: Int, EPosX: Int, EPosY: Int) {
  def draw(p: PApplet): Unit = {
    p.rect(SPosX, SPosY, EPosX - SPosX, EPosY - SPosY)

  }

}