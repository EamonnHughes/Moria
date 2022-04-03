package moria

import processing.core.PApplet

case class Exit(loc: Location) {
  def draw(p: PApplet): Unit = {
    p.fill(0, 100, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
  }
  def nextLevelCheck: Unit = {
    if (World.player.loc == loc) {
      if (World.currentLevelNumber + 1 < World.levelList.length) {

        World.currentLevelNumber += 1
        World.player.loc = World.levelList(World.currentLevelNumber).entrance
        World.player.dst = World.player.loc
      } else {
        println("YOU WON!")
        System.exit(0)
      }
    }
  }
}
