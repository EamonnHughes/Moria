package moria

case class gearItem(
    typeOfGear: String,
    material: String,
    armorMod: Float,
    evasionMod: Float,
    healthAdd: Int,
    regenAdd: Int,
    prefix: String
) {
  def showInfo(): Unit = {
    println(
      s"$prefix $material $typeOfGear \n ---------- \n armor:$armorMod \n evasion:$evasionMod \n adds $healthAdd health \n regenerates $regenAdd health \n ----------"
    )
  }
}
