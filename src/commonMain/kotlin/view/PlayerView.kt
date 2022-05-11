package view

import Player
import com.soywiz.korge.view.Circle
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Text
import com.soywiz.korim.color.Colors

class PlayerView(player: Player) : Container(){
    init {

        addChild(Circle(50.0, Colors.BEIGE))
        val centerX = getBounds().width/2
        val centerY = getBounds().height/2
        val hp = Text("hp: " + player.hp.toString(), 16.0, Colors.BLACK)
        hp.x = centerX
        hp.y = centerY
        addChild(hp)

        val ap = Text("ap: "+player.ap.toString(), 12.0, Colors.BLUE)
        ap.x = centerX
        ap.y = centerY + 10
        addChild(ap)


    }
}