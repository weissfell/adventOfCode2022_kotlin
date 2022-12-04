package main.kotlin

import main.kotlin.generalutils.ChristmasFileReader

class Day02tictactoe(val src: String) {
    val strLines = ChristmasFileReader(src).fetchLinesAsString()

    private val attackMoveRock = AttackMove('A', "Rock")
    private val attackMovePaper = AttackMove('B', "Paper")
    private val attackMoveScissor = AttackMove('C', "Scissor")
    private val defenseMoveRock = DefenseMove('X', "Rock", attackMoveScissor, attackMovePaper, 1)
    private val defenseMovePaper = DefenseMove('Y', "Paper", attackMoveRock, attackMoveScissor, 2)
    private val defenseMoveScissor = DefenseMove('Z', "Scissor", attackMovePaper, attackMoveRock, 3)
    private val defaultLosePoints = 0
    private val defaultDrawPoints = 3
    private val defaultVictoryPoints = 6

    fun calcDay2() {
        attackMoveRock.weakMove = defenseMovePaper
        attackMoveRock.strongMove = defenseMoveScissor
        attackMoveRock.drawMove = defenseMoveRock
        attackMovePaper.weakMove = defenseMoveScissor
        attackMovePaper.strongMove = defenseMoveRock
        attackMovePaper.drawMove = defenseMovePaper
        attackMoveScissor.weakMove = defenseMoveRock
        attackMoveScissor.strongMove = defenseMovePaper
        attackMoveScissor.drawMove = defenseMoveScissor


        var victoryPoints: Int = 0
        strLines.forEach { line ->
            val currAttackMove = getAttackMove(line[0])
            val currDefenseMove = getDefenseMove(line[2])
            victoryPoints += fetchVictorypoints(currDefenseMove, currAttackMove)
        }
        println("Day 2 Pt. I: $victoryPoints")

        victoryPoints = 0
        strLines.forEach { line ->
            val currAttackMove = getAttackMove(line[0])
            val currDefenseMove = calcExpectedMove(line[2], currAttackMove)
            victoryPoints += fetchVictorypoints(currDefenseMove, currAttackMove)
        }
        println("Day 2 Pt. II: $victoryPoints")


    }

    private fun fetchVictorypoints(
        currDefenseMove: DefenseMove,
        currAttackMove: AttackMove
    ): Int {
        var victoryPoints1 = 0
        victoryPoints1 += currDefenseMove.victoryPoints
        victoryPoints1 += if (currDefenseMove.strongMove.name == currAttackMove.name) {
            defaultVictoryPoints
        } else if (currDefenseMove.weakMove.name == currAttackMove.name) {
            defaultLosePoints
        } else {
            defaultDrawPoints
        }
        return victoryPoints1
    }

    fun getAttackMove(shortName: Char): AttackMove {
        if (shortName == 'A') {
            return attackMoveRock
        }
        if (shortName == 'B') {
            return attackMovePaper
        }
        return attackMoveScissor
    }

    fun getDefenseMove(shortName: Char): DefenseMove {
        if (shortName == 'X') {
            return defenseMoveRock
        }
        if (shortName == 'Y') {
            return defenseMovePaper
        }
        return defenseMoveScissor
    }

    fun calcExpectedMove(shortName: Char, attackMove: AttackMove): DefenseMove {
        if (shortName == 'X') { //lose
            return attackMove.strongMove
        }
        if (shortName == 'Y') { //draw
            return attackMove.drawMove
        }
        //if (shortName == 'Z') { // win
        return attackMove.weakMove
        //}
    }

}

class AttackMove(
    val shortName: Char, val name: String
) {
    lateinit var strongMove: DefenseMove
    lateinit var weakMove: DefenseMove
    lateinit var drawMove: DefenseMove
}

class DefenseMove(
    val shortName: Char,
    val name: String,
    val strongMove: AttackMove,
    val weakMove: AttackMove,
    val victoryPoints: Int
)

