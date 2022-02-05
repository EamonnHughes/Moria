package moria

object SimpleNavigation {

  def navigateObject(nObj: NavigatingObject with DealsDamage): Boolean = {

    val movX = math.signum(nObj.dst.x - nObj.loc.x)
    val movY = math.signum(nObj.dst.y - nObj.loc.y)
    var moved = false

    var newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)
    if (nObj == World.player) println(s"Nav From ${nObj.loc} to ${newLoc}")

    if (
      (World.findThing(newLoc) == null || newLoc == nObj.loc) && World.rooms
        .exists(room => room.isInside(newLoc.x * 16, newLoc.y * 16))
    ) {
      moved = newLoc != nObj.loc
      nObj.loc = newLoc
      if (nObj == World.player) println(s"Moved $moved")
    } else {
      World.findThing(newLoc) match {
        case hh: NavigatingObject with HasHealth =>
          if (
            nObj.isInstanceOf[Enemy] && World.findThing(newLoc) == World.player
          ) {
            Combat.dealDamage(nObj, hh)

            nObj.dst = nObj.loc

          }
          if (nObj == World.player) {

            Combat.dealDamage(nObj, hh)

            nObj.dst = nObj.loc

            moved = true
          }
          if (
            nObj.isInstanceOf[Projectile] && World.findThing(
              newLoc
            ) != World.player
          ) {
            Combat.dealDamage(nObj, hh)

            nObj.dst = nObj.loc

            moved = true
          }
        case _ =>
      }

    }
    moved
  }

}
