package view.fight.enemy

import Attack
import fight.Enemy
import com.soywiz.korge.view.*
import fight.HitListener
import view.BitmapRegistry
import view.fight.HealthView
import view.fight.ViewHiglighter
import view.fight.effects.BloodEffectView
import view.fight.effects.SlashEffectView

class EnemyView(val enemy: Enemy, val bitmapRegistry: BitmapRegistry) : Container(), HitListener {
    val bloodEffectView = BloodEffectView(bitmapRegistry)
    val image = Image(bitmapRegistry.getEnemy()).scale(0.5)
    var higlighter = ViewHiglighter(image)
    init {

        enemy.setHitListener(this)
        addChild(image)
        val healthView = HealthView(enemy.health)
        addChild(healthView)
        healthView.y = image.scaledHeight + 10

        bloodEffectView.scale = 0.5
        addChild(bloodEffectView)

        addUpdater {
            if (enemy.isDead()) {
                image.alpha = 0.2
            }
        }
    }

    fun highlight(){
        higlighter.select()
    }

    fun unHighlight(){
        higlighter.unselect()
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