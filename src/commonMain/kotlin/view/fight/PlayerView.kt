package view.fight

import Player
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import view.BitmapRegistry

class PlayerView(player: Player, bitmapRegistry: BitmapRegistry) : Container(){
    init {


        val view = Image(bitmapRegistry.getPlayer())
        view.scale = 0.7
        addChild(view)
        val healthView = HealthView(player.hp)
        healthView.y = view.scaledHeight + 10
        addChild(healthView)


        addUpdater {
            healthView.currentHp = player.hp
        }

    }
}