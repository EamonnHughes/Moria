package moria

case class Location(x: Int, y: Int) {
  def findAdjacents: List[Location] = {
    val adj = List(
      Location(x, y - 1),
      Location(x, y + 1),
      Location(x - 1, y),
      Location(x + 1, y),
      Location(x - 1, y - 1),
      Location(x - 1, y + 1),
      Location(x + 1, y - 1),
      Location(x + 1, y + 1)
    )
    adj
  }
  def +(delta: Delta): Location = {
    Location(x + delta.dx, y + delta.dy)
  }
  def distanceFrom(oLocation: Location): Int = {
    val dx = oLocation.x - x
    val dy = oLocation.y - y
    Math.sqrt(dx * dx + dy * dy).toInt
  }

}

case class Delta(dx: Int, dy: Int) {
  def rotate: Delta = {
    if (dx == 0) Delta(dy, 0)
    else Delta(0, -dx)
  }
  def moveByDelta(location: Location): Location = {
    Location(location.x + dx, location.y + dy)
  }
}
