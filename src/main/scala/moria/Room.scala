package moria

import processing.core.PApplet

case class Room(location: Location, width: Int, height: Int) {
  def draw(p: PApplet): Unit = {
    p.fill(255, 255, 255)
    p.rect(location.x * 16, location.y * 16, width * 16, height * 16)
  }
  def isInRoom(loc: Location): Boolean = {
    if (
      loc.x < location.x + width && loc.x >= location.x && loc.y < location.y + height && loc.y >= location.y
    ) true
    else false
  }
}
