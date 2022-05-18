package view.fight.enemy

import fight.Fight
import com.soywiz.korge.view.Container
import view.BitmapRegistry

class EnemiesView(fight: Fight, bitmapRegistry: BitmapRegistry) : Container() {
    init {
        var x = 0.0
        fight.enemies.forEach { enemy ->
            val view = EnemyView(enemy, bitmapRegistry)
            view.x = x; x += view.scaledWidth * 1.2
            addChild(view)
        }


    }

}