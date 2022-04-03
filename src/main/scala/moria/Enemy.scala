package moria

import processing.core.PApplet

case class Enemy(var loc: Location) extends Thing {
  var distanceFromPlayer = 100
  def draw(p: PApplet): Unit = {
    p.fill(255, 0, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
    distanceFromPlayer = Math
      .sqrt(
        (Math.abs(loc.x - World.player.loc.x) * Math
          .abs(loc.x - World.player.loc.x)) + Math
          .abs(loc.y - World.player.loc.y) * Math
          .abs(loc.y - World.player.loc.y)
      )
      .toInt
  }
  def chooseTarget(): Unit = {}
}
