package moria

object World {
  var rooms = List(
    Room(2, 2, 32, 16)
  )
  var enemies = List(Enemy(2, 2, 3, 3, 5, 75, 10, 1))
  var player = Player(4, 4, 4, 4, 10, 50, 15, 2)
}
