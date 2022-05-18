package view.fight

import fight.Fight
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.addUpdater

class ApView(fight: Fight): Container() {

    init {
        val apText = Text(formatApText(fight), 50.0)
        addChild(apText)

        addUpdater {
            apText.text = formatApText(fight)
        }
    }

    private fun formatApText(fight: Fight) = "AP: ${fight.ap}/${fight.player.ap}"
}