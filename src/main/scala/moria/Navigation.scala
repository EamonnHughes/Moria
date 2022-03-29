package moria

import scala.collection.mutable

object Navigation {
  def findPath(start: Location, finish: Location): Option[Path] = {
    val visitedCells = mutable.Set.empty[Location]
    var paths = List(Path(List(start)))
    while (!paths.exists(path => path.getHead == finish) && paths.nonEmpty) {
      paths = for {
        path <- paths
        newPath <- path.extendPaths(visitedCells, World.findSquad(start))
      } yield {
        newPath
      }
    }
    paths.find(path => path.getHead == finish)
  }
}
