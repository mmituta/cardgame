package view.fight.enemy

import Enemy
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import view.BitmapRegistry
import view.fight.HealthView

class EnemyView(enemy: Enemy, bitmapRegistry: BitmapRegistry) : Container() {
    init {
        val image = Image(bitmapRegistry.getEnemy()).scale(0.5)

        addChild(image)
        val healthView = HealthView(enemy.hp)
        addChild(healthView)
        healthView.y = image.scaledHeight + 10


        addUpdater {
            healthView.currentHp = enemy.hp
        }
    }
}