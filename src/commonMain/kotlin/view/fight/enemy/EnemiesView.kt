package view.fight.enemy

import Enemy
import com.soywiz.korge.view.Container
import view.BitmapRegistry

class EnemiesView(enemies: List<Enemy>, bitmapRegistry: BitmapRegistry) : Container() {
    init {
        var x = 0.0;
        enemies.forEach { enemy -> val view = EnemyView(enemy, bitmapRegistry); view.x = x; x += view.scaledWidth * 1.2; addChild(view) }
    }

}