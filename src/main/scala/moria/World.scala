package moria

object World {
  var player = Player(Location(4, 4), Location(4, 12))
  val levelFirst = Level(
    List(Room(Location(2, 2), 24, 24), Room(Location(26, 4), 5, 1)),
    Exit(Location(8, 8))
  )
  val levelSecond = Level(
    List(Room(Location(4, 4), 24, 24), Room(Location(28, 6), 5, 1)),
    Exit(Location(14, 16))
  )
  var currentLevel = levelFirst
  var listOfThings = List(player)
  def findSquad(location: Location): Thing = { // nulls
    listOfThings.find(thing => thing.loc == location).orNull
  }
}
