package moria

object Navigation {

  var doAttack = false
  def navigateObject(nObj: NavigatingObject with DealsDamage): Boolean = {

    var movX = math.signum(nObj.dst.x - nObj.loc.x)
    var movY = math.signum(nObj.dst.y - nObj.loc.y)

    var newLoc = Location(nObj.loc.x + movX, nObj.loc.y + movY)

    if (
      (World.findThing(newLoc) == null || newLoc == nObj.loc) && World.rooms
        .exists(room => room.isInside(newLoc.x * 16, newLoc.y * 16))
    ) {
      nObj.loc = newLoc
    } else {
      World.findThing(newLoc) match {
        case hh: NavigatingObject with HasHealth =>
          Combat.dealDamage(nObj, hh)
          if (nObj == Player) { doAttack = true }
        case _ =>
      }

      newLoc = nObj.loc
    }

    movX != 0 || movY != 0
  }

}
