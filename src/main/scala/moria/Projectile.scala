package moria

case class Projectile(
    loc: Location,
    dst: Location,
    toHitMod: Int,
    damageDealt: Int
) extends Thing
    with NavigatingObject
    with DealsDamage {}
