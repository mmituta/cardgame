package view.fight

import fight.Player
import com.soywiz.korge.view.*
import view.BitmapRegistry

class PlayerView(player: Player, bitmapRegistry: BitmapRegistry) : Container(){
    init {


        val view = Image(bitmapRegistry.getPlayer())
        view.scale = 0.7
        addChild(view)
        val healthView = HealthView(player.health)
        healthView.y = view.scaledHeight + 10
        addChild(healthView)




    }
}