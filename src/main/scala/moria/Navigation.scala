package moria

object Navigation {

  var doAttack = false
  def navigateObject(nObj: NavigatingObject with DealsDamage): Boolean = {

    val movX = math.signum(nObj.dst.x - nObj.loc.x)
    val movY = math.signum(nObj.dst.y - nObj.loc.y)

    var newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)

    if (
      (World.findThing(newLoc) == null || newLoc == nObj.loc) && World.rooms
        .exists(room => room.isInside(newLoc.x * 16, newLoc.y * 16))
    ) {
      nObj.loc = newLoc
    } else {
      World.findThing(newLoc) match {
        case hh: NavigatingObject with HasHealth =>
          if (
            nObj.isInstanceOf[Enemy] && World.findThing(newLoc) == World.player
          ) {
            Combat.dealDamage(nObj, hh)
            newLoc = nObj.loc

          }
          if (nObj == Player) {

            Combat.dealDamage(nObj, hh)

            newLoc = nObj.loc
            doAttack = true

          }
        case _ =>
          doAttack = false
      }

    }

    movX != 0 || movY != 0 || doAttack
  }

}
