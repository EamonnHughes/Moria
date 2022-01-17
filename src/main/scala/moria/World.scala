package moria

object World {
  var rooms = List(
    Room(2, 2, 32, 16)
  )
  var enemies = List(
    Enemy(Location(2, 2), Location(2, 2), 5, 45, 10, 1),
    Enemy(Location(8, 8), Location(8, 8), 5, 45, 10, 1)
  )
  var player = Player(Location(4, 4), Location(4, 4), 10, 50, 15, 2)

  def things: List[Thing] = player :: enemies

  def findThing(location: Location): Thing = { // null
    things.find(thing => thing.loc == location).orNull
  }
}
