package view

import FightController
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.RoundRect
import com.soywiz.korim.color.Colors

class EndTurnView(controller: FightController) : Container() {
    init {
        val view = RoundRect(40.0, 40.0, 5.0, fill = Colors.GREEN)
        view.onClick {
            controller.startTurn()
        }
        addChild(view)
    }
}