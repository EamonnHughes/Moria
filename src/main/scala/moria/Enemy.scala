package moria

import processing.core.PApplet

case class Enemy(var loc: Location, var dst: Location) extends Thing {

  var pathToDest = Option.empty[Path]
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
    dst = World.player.loc
  }
  def move: Unit = {
    for {
      path <- pathToDest
    } {
      val nextLoc = path.getHead
      loc = nextLoc
      pathToDest = path.tail
    }
  }

  def chooseTarget(): Unit = {}

  def navTo: Unit = {
    if (World.currentLevel.roomList.exists(room => room.isInRoom(dst))) {
      pathToDest = Navigation.findPath(dst, loc).flatMap(path => path.tail)
    } else { dst = loc }
  }
}
