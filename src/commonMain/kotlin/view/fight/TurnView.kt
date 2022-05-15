package view.fight

import Fight
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.addUpdater

class TurnView(fight: Fight) : Container() {
    init {
        val turnView = Text("Turn " + fight.turn)
        addChild(turnView)
        val apView = Text(fight.ap.toString())
        apView.y = 50.0
        addChild(apView)

        addUpdater {
            turnView.text = "Turn " + fight.turn
            apView.text = fight.ap.toString()
        }

    }
}