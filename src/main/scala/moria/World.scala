package moria

object World {
  var player = Player(Location(4, 4), Location(0, 0), 5, 10)
  var currentLevelNumber = 0
  var levelList = List(
    Level(
      List(Room(Location(4, 4), 24, 24), Room(Location(28, 6), 5, 1)),
      Exit(Location(32, 6)),
      Location(4, 4)
    ),
    Level(
      List(Room(Location(2, 2), 24, 24), Room(Location(26, 4), 5, 1)),
      Exit(Location(30, 4)),
      Location(2, 2)
    ),
    Level(
      List(Room(Location(3, 3), 30, 30)),
      Exit(Location(12, 12)),
      Location(6, 6)
    )
  )
  var currentLevel = levelList(currentLevelNumber)
  var listOfThings = List(player)
  def findSquad(location: Location): Thing = { // nulls
    listOfThings.find(thing => thing.loc == location).orNull
  }
}
