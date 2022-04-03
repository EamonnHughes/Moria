package moria

import processing.core.PApplet

case class Exit(loc: Location) {
  def draw(p: PApplet): Unit = {
    p.fill(0, 100, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
  }
}
