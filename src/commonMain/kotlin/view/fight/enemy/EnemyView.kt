package view.fight.enemy

import fight.Enemy
import com.soywiz.korge.view.*
import view.BitmapRegistry
import view.fight.HealthView

class EnemyView(enemy: Enemy, bitmapRegistry: BitmapRegistry) : Container() {
    init {
        val image = Image(bitmapRegistry.getEnemy()).scale(0.5)

        addChild(image)
        val healthView = HealthView(enemy.health)
        addChild(healthView)
        healthView.y = image.scaledHeight + 10


        addUpdater {
            if (enemy.isDead()) {
                image.alpha = 0.2
            }

        }
    }
}