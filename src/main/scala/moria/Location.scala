package moria
case class Location(x: Float, y: Float) {
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

  def distanceFrom(oLocation: Location): Float = {
    val dx = oLocation.x - x
    val dy = oLocation.y - y
    Math.sqrt(dx * dx + dy * dy).toFloat
  }
}

case class Delta(dx: Float, dy: Float) {
  def rotate: Delta = {
    if (dx == 0) Delta(dy, 0)
    else Delta(0, -dx)
  }
  def moveByDelta(location: Location): Location = {
    Location(location.x + dx, location.y + dy)
  }
}
