package moria
import scala.collection.mutable

case class Path(points: List[Location]) {
  def getHead: Location = {
    points.head
  }
  def tail: Option[Path] = {
    if (points.length > 1) {
      Some(Path(points.tail))
    } else {
      None
    }

  }
  def add(location: Location): Path = {
    Path(location :: points)
  }
  def extendPaths(visCells: mutable.Set[Location], unit: Thing): List[Path] = {
    for {
      loc <- getHead.findAdjacents
      if visCells.add(loc)
      if World.currentLevel.roomList.exists(room => room.isInRoom(loc))
    } yield add(loc)
  }
}
