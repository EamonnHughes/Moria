package moria

import scala.util.Random

object Combat {
  def dealDamage(
      attacker: NavigatingObject with DealsDamage,
      defender: NavigatingObject with HasHealth
  ): Unit = {
    var rToHit = Random.nextInt(100) - attacker.toHitMod
    println(rToHit)
    if (rToHit <= defender.ac) {
      defender.health -= attacker.damageDealt
      println(defender.health)
    }
  }
}
