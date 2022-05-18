package view.fight.enemy

import com.soywiz.korge.input.*
import fight.Fight
import com.soywiz.korge.view.Container
import view.BitmapRegistry
import view.fight.ViewHiglighter

class EnemiesView(fight: Fight, bitmapRegistry: BitmapRegistry) : Container() {
    var selecting = false

    init {
        var x = 0.0
        fight.enemies.forEach { enemy ->
            val view = EnemyView(enemy, bitmapRegistry)
            view.x = x; x += view.scaledWidth * 1.2
            view.onClick { event -> enemyClicked(view) }
            view.onOver { view.highlight() }
            view.onOut { view.unHighlight() }
            addChild(view)
        }

//        setSelectingState()
    }



    fun enemyClicked(enemyView: EnemyView) {

    }

    fun zoomIn(enemyView: EnemyView) {

    }

    fun zoomOut(enemyView: EnemyView) {

    }

    fun setSelectingState() {
        selecting = true
    }

    fun removeSelectingState() {
        selecting = false
//        originView = null
    }

}