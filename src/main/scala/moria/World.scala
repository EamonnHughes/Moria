package moria

object World {
  var player = Player(Location(4, 4), Location(6, 2))
  var rooms = List(Room(Location(2, 2), 4, 4), Room(Location(2, 8), 4, 4))
  var listOfThings = List(player)
  def findSquad(location: Location): Thing = { // nulls
    listOfThings.find(thing => thing.loc == location).orNull
  }
}
