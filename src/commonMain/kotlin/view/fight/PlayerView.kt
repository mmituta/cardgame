package view.fight

import Attack
import fight.Player
import com.soywiz.korge.view.*
import fight.HitListener
import view.BitmapRegistry
import view.fight.effects.BloodEffectView
import view.fight.effects.SlashEffectView

class PlayerView(player: Player, val bitmapRegistry: BitmapRegistry) : Container(), HitListener{
    private val bloodEffectView = BloodEffectView(bitmapRegistry)

    init {
        player.setHitListener(this)
        val view = Image(bitmapRegistry.getPlayer())
        view.scale = 0.7
        addChild(view)
        val healthView = HealthView(player.health)
        healthView.y = view.scaledHeight + 10
        addChild(healthView)

    }

    override fun onHit(attack: Attack) {
        if(attack.type == "Slash"){
            val slashEffectView = SlashEffectView(bitmapRegistry)
            slashEffectView.scale = 0.5
            addChild(slashEffectView)
            slashEffectView.play()
            bloodEffectView.play()
        }
    }
}