package moria

import processing.core.PApplet

case class Player(var loc: Location, var dst: Location) extends Thing {
  var pathToDest = Option.empty[Path]

  def draw(p: PApplet): Unit = {
    p.fill(0, 255, 0)
    p.rect(loc.x * 16, loc.y * 16, 16, 16)
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

  def navTo: Unit = {
    if (World.levelFirst.roomList.exists(room => room.isInRoom(dst))) {
      pathToDest = Navigation.findPath(dst, loc).flatMap(path => path.tail)
    } else { dst = loc }
  }
}
