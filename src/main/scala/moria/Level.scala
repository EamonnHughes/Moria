package moria

case class Level(
    roomList: List[Room],
    exit: Exit,
    entrance: Location,
    enemyList: List[Enemy]
)
