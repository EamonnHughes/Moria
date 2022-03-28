package moria

import processing.core.PApplet

case class Player(var loc: Location) extends Thing {
  //var pathToDest = Option.empty[Path]

  def navigateTo(loc: Location): Unit = {}
  def draw(p: PApplet): Unit = {
    p.fill(0, 255, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
  }
}
