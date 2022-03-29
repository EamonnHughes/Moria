package moria

object World {
  var player = Player(Location(4, 4))
  var rooms = List(Room(Location(2, 2), 4, 4), Room(Location(2, 8), 4, 4))
}
