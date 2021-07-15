package moria

import scala.util.Random

object maprenderer {
  val mazeEnterX: Int = Random.nextInt(700)
  val mazeEnterY: Int = Random.nextInt(500)
  val firstexit: Int = Random.nextInt(40)
  var mr1y: Int = Random.nextInt(500)
  while (mr1y >= mazeEnterY - 80 && mr1y <= mazeEnterY + 80) {
    mr1y = Random.nextInt(500)
  }
  var mr1x: Int = Random.nextInt(700)
  while (mr1x >= mazeEnterX - 80 && mr1x <= mazeEnterX + 80) {
    mr1x = Random.nextInt(700)
  }
  var mr2y: Int = Random.nextInt(500)
  while (
    mr2y >= mazeEnterY - 80 && mr2y <= mazeEnterY + 80 && mr2y >= mr1y - 40 && mr2y <= mr1y + 40
  ) {
    mr2y = Random.nextInt(500)
  }
  var mr2x: Int = Random.nextInt(700)
  while (
    mr2x >= mazeEnterX - 80 && mr2x <= mazeEnterX + 80 && mr2x >= mr1x - 40 && mr2x <= mr1x + 40
  ) {
    mr2x = Random.nextInt(700)
  }
  var entx = Random.nextInt(40) + 40
  var enty = Random.nextInt(40) + 40
  var r1x = Random.nextInt(30) + 10
  var r1y = Random.nextInt(30) + 10
  var r2x = Random.nextInt(30) + 10
  var r2y = Random.nextInt(30) + 10

}
