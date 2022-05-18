package view.fight

import fight.Fight
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.Views
import com.soywiz.korim.color.Colors

private const val HEIGHT = 80.0

class TopBarView(views: Views, fight: Fight) : Container(){
    init {
        val background = RoundRect(views.virtualWidthDouble, HEIGHT, 0.0, 0.0, Colors.BLACK, Colors.BLACK )
        background.alpha = 0.8
        addChild(background)

        val turnView = TurnView(fight)
        addChild(turnView)
        turnView.x = views.virtualWidthDouble / 2 - turnView.scaledWidth/2
        turnView.y = HEIGHT/2 - turnView.scaledHeight/2
    }
}