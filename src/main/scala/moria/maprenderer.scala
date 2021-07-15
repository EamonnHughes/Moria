package moria

import scala.util.Random

object maprenderer {
  val mazeEnterX: Int = Random.nextInt(700)
  val mazeEnterY: Int = Random.nextInt(500)
  val firstexit: Int = Random.nextInt(40)
  var mr1y: Int = Random.nextInt(500)
  while (mr1y >= mazeEnterY - enty && mr1y <= mazeEnterY + enty) {
    mr1y = Random.nextInt(500)
  }
  var mr1x: Int = Random.nextInt(700)

  var mr2y: Int = Random.nextInt(500)
  while (
    mr2y >= mazeEnterY - enty && mr2y <= mazeEnterY + enty && mr2y >= mr1y - r1y && mr2y <= mr1y + r1y
  ) {
    mr2y = Random.nextInt(500)
  }
  var mr2x: Int = Random.nextInt(700)

  var entx = Random.nextInt(20) + 60
  var enty = Random.nextInt(20) + 60
  var r1x = Random.nextInt(10) + 30
  var r1y = Random.nextInt(10) + 30
  var r2x = Random.nextInt(10) + 30
  var r2y = Random.nextInt(10) + 30

}
