package view.fight

import Player
import com.soywiz.korge.view.Circle
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.Text
import com.soywiz.korim.color.Colors
import view.BitmapRegistry

class PlayerView(player: Player, bitmapRegistry: BitmapRegistry) : Container(){
    init {


        val view = Image(bitmapRegistry.getPlayer())
        view.scale = 0.7
        addChild(view)
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