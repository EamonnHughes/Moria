package moria

object World {

  var isMenu = false
  var startUp = true
  var rooms = List(
    Room(2, 2, 32, 16),
    Room(34, 4, 4, 1),
    Room(38, 2, 8, 8)
  )
  var enemies = List(
    Enemy(Location(2, 2), Location(2, 2), 5, 45, 10, 1, 5),
    Enemy(Location(8, 8), Location(8, 8), 5, 45, 10, 1, 5)
  )
  var gear = List(
    gearItem("Helm", "Iron", 1, 1, 1, 1, "Boring")
  )
  var player: Player = Player(
    Location(4, 4),
    Location(4, 4),
    10,
    50,
    15,
    2,
    10,
    10,
    10,
    10,
    10,
    10,
    10,
    10,
    10,
    10,
    16,
    16,
    16,
    16,
    16,
    16,
    16,
    16,
    16
  )

  def things: List[Thing] = player :: enemies

  def findThing(location: Location): Thing = { // null
    things.find(thing => thing.loc == location).orNull
  }

  def roomIsIn(nObj: NavigatingObject): Int = {
    var roomNum = 0
    for (i <- World.rooms.indices) {
      val rRoom = World.rooms(i)
      if (rRoom.isInside(nObj.loc.x, nObj.loc.y)) {
        roomNum = i
      }

    }
    roomNum
  }
  def nextFoe(newLoc: Location): Int = {
    var enNum = 0
    for (i <- World.enemies.indices) {
      val eEnemy = World.enemies(i)
      if (eEnemy.loc == newLoc) {
        enNum = i
      }

    }
    val foeNum = enNum
    foeNum
  }
  def checkForDead(): Unit = {

    enemies = enemies.filter(enemy => enemy.health > 0)

  }
}
