package moria

object World {
  var player = Player(Location(4, 4), Location(4, 12))
  var rooms = List(Room(Location(2, 2), 24, 24), Room(Location(26, 4), 5, 1))
  var listOfThings = List(player)
  def findSquad(location: Location): Thing = { // nulls
    listOfThings.find(thing => thing.loc == location).orNull
  }
}
