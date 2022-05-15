package view.fight

import Fight
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.addUpdater

class TurnView(fight: Fight) : Container() {
    init {
        val turnView = Text(formatTurnText(fight), 25.0)
        addChild(turnView)
        addUpdater {
            turnView.text = formatTurnText(fight)
        }

    }

    private fun formatTurnText(fight: Fight) = "Turn " + fight.turn
}