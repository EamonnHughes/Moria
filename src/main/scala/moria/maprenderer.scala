package moria

import scala.util.Random

object maprenderer {
  val mazeenterx = Random.nextInt(700)
  val mazeentery = Random.nextInt(500)
  val firstexit = Random.nextInt(40)
  var mr1y = Random.nextInt(500)
  while (mr1y >= mazeentery - 80 && mr1y <= mazeentery + 80) {
    mr1y = Random.nextInt(500)
  }
  var mr1x = Random.nextInt(700)
  while (mr1x >= mazeenterx - 80 && mr1x <= mazeenterx + 80) {
    mr1x = Random.nextInt(700)
  }
  var mr2y = Random.nextInt(500)
  while (
    mr2y >= mazeentery - 80 && mr2y <= mazeentery + 80 && mr2y >= mr1y - 40 && mr2y <= mr1y + 40
  ) {
    mr2y = Random.nextInt(500)
  }
  var mr2x = Random.nextInt(700)
  while (
    mr2x >= mazeenterx - 80 && mr2x <= mazeenterx + 80 && mr2x >= mr1x - 40 && mr2x <= mr1x + 40
  ) {
    mr2x = Random.nextInt(700)
  }
  var entx = 1
  var enty = 1
  var r1x = 1
  var r1y = 1
  var r2x = 1
  var r2y = 1

}
