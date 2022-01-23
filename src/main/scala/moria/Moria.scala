package moria

import processing.core._
import processing.event.{KeyEvent, MouseEvent}

class Moria extends PApplet {

  var time: Long = System.currentTimeMillis
  val BoardWidth = 1024
  val BoardHeight = 512
  var doneNothing = false

  override def setup(): Unit = {}

  override def settings(): Unit = {
    size(BoardWidth, BoardHeight)

  }

  override def draw(): Unit = {

    background(100, 100, 100)
    fill(255, 255, 255)

    if (World.startUp) {
      fill(255, 255, 0)
      rect(0, 0, 1024, 512)

      fill(0, 0, 0)
      text("select race", 256, 190)
      rect(256, 200, 32, 16)
      rect(300, 200, 32, 16)
      rect(344, 200, 32, 16)
      fill(255, 255, 255)
      textSize(8)
      text("Human", 256, 210)
      text("Dwarf", 300, 210)
      text("Elf", 344, 210)

      fill(0, 0, 0)
      text("select class", 256, 256)
      rect(256, 266, 32, 16)
      rect(300, 266, 32, 16)
      rect(344, 266, 32, 16)
      fill(255, 255, 255)
      textSize(8)
      text("Warrior", 256, 276)
      text("Rogue", 300, 276)
      text("Mage", 344, 276)
    } else {

      World.rooms.foreach { room =>
        room.draw(this)
      }

      stroke(0, 0, 0)

      World.enemies.foreach { enemy => enemy.draw(this) }
      World.player.draw(this)

      fill(255, 255, 0, 75)

      rect((mouseX / 16).ceil * 16, (mouseY / 16).ceil * 16, 16, 16)
      if (World.isMenu) {
        println("Menu")
        rect(4, 4, 1016, 504)
        fill(255, 255, 0)
        rect(8, 8, 496, 496)
        rect(520, 8, 496, 496)
        fill(0, 0, 0)
        text(
          s" STR: ${World.player.Strength}(${World.player.bStrength}) \n FIN: ${World.player.Finesse}(${World.player.bFinesse}) \n FRT: ${World.player.Fortitude}(${World.player.bFortitude}) \n ENG: ${World.player.Energy}(${World.player.bEnergy}) \n INT: ${World.player.Intelligence}(${World.player.bIntelligence}) \n PRS: ${World.player.Persuasion}(${World.player.bPersuasion}) \n IMD: ${World.player.Intimidation}(${World.player.bIntimidation}) \n RSM: ${World.player.Rationalism}(${World.player.bRationalism}) \n PCP: ${World.player.Perception}(${World.player.bPerception})",
          540,
          28
        )
      } else {
        Update(.2f)
      }
    }

  }

  def Update(tTime: Float): Unit = {
    val currentTime = System.currentTimeMillis

    if (currentTime - time > tTime * 1000) {
      val moved = Navigation.navigateObject(
        World.player
      )

      if (moved || doneNothing) {
        println(s"Moved $moved done nothing $doneNothing")
        World.enemies.foreach(enemy => enemy.chooseState())

        World.enemies.foreach(enemy => Navigation.navigateObject(enemy))

      }
      time = currentTime
      doneNothing = false

    }

    World.checkForDead()
    World.player.checkForDead()

  }

  override def mousePressed(event: MouseEvent): Unit = {
    World.player.pClick(mouseX, mouseY)
  }

  override def keyPressed(event: KeyEvent): Unit = {
    World.player.pressKey(keyCode)
    if (key == ' ') {
      doneNothing = true
    }
    if (key == 'i' && !World.isMenu) { World.isMenu = true }
    else if (key == 'i' && World.isMenu) { World.isMenu = false }
    if (key == 'c') { World.startUp = false }
  }

}

object Moria extends App {

  PApplet.main(classOf[Moria])
}
