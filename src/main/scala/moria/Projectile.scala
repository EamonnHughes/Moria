package moria

case class Projectile(
    var loc: Location,
    var dst: Location,
    var toHitMod: Int,
    var damageDealt: Int
) extends Thing
    with NavigatingObject
    with DealsDamage {}
