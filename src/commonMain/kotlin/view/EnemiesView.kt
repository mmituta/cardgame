package view

import Enemy
import com.soywiz.korge.view.Container

class EnemiesView(enemies: List<Enemy>) : Container() {
    init {
        var x = 0.0;
        enemies.forEach { enemy -> val view = EnemyView(enemy); view.x = x; x += view.width * 1.2; addChild(view) }
    }

}