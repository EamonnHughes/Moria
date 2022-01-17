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

  def roomIsIn(nObj: NavigatingObject): Int = {
    var roomNum = 0
    for (i <- 0 until World.rooms.length) {
      var rRoom = World.rooms(i)
      if (rRoom.isInside(nObj.loc.x, nObj.loc.y)) {
        roomNum = i
      }

    }
    roomNum
  }
  def nextFoe(nObj: NavigatingObject, newLoc: Location): Int = {
    var enNum = 0
    for (i <- 0 until World.enemies.length) {
      var eEnemy = World.enemies(i)
      if (eEnemy.loc == newLoc) {
        enNum = i
      }

    }
    var foeNum = enNum
    foeNum
  }
  def checkForDead(): Unit = {

    enemies = enemies.filter(enemy => enemy.health > 0)

  }
}
