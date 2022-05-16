package view.fight

import FightController
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.Container
import view.BitmapRegistry
import view.ButtonView

class EndTurnView(controller: FightController, bitmapRegistry: BitmapRegistry) : Container() {
    init {
        val view = ButtonView("End turn", bitmapRegistry)
        view.onClick {
            controller.endTurn()
        }
        addChild(view)
    }
}