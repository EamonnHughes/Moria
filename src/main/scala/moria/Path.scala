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
  def extendPaths(
      visCells: mutable.Set[Location],
      unit: Thing
  ): List[Path] = {
    var unitsExcluding =
      World.things.filterNot(thing => thing == unit)
    for {
      loc <- getHead.findAdjacents
      if visCells.add(loc)
      if World.rooms.exists(room => room.isInside(loc))
      if unitsExcluding.forall(squad => squad != loc)
    } yield add(loc)
  }
}
