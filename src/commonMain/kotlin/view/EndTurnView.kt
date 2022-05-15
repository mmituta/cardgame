package view

import FightController
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.Container
import com.soywiz.korim.bitmap.Bitmap

class EndTurnView(controller: FightController, bitmap: Bitmap) : Container() {
    init {
        val view = ButtonView("End turn", bitmap)
        view.onClick {
            controller.startTurn()
        }
        addChild(view)
    }
}