package moria

object projectileNavigate {
  def navigateObject(nObj: Projectile): Unit = {
    val movX = math.signum(nObj.dst.x - nObj.loc.x)
    val movY = math.signum(nObj.dst.y - nObj.loc.y)
    var moved = false

    val newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)
    if (
      (World.findThing(newLoc) == null || newLoc == nObj.loc) && World.rooms
        .exists(room => room.isInside(newLoc.x * 16, newLoc.y * 16))
    ) {
      moved = newLoc != nObj.loc
      nObj.loc = newLoc
    } else {
      World.findThing(newLoc) match {
        case hh: NavigatingObject with HasHealth =>
          if (
            nObj.isInstanceOf[Projectile] && World.findThing(
              newLoc
            ) != World.player
          ) {
            Combat.dealDamage(nObj, hh)
            moved = true

          }
        case _ =>
      }
    }
    if (moved || nObj.loc == nObj.dst) {
      println("destroy")
      World.projectilesList = World.projectilesList.filterNot(p => p == nObj)
    }
  }
}
