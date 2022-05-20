package view.fight.enemy

import com.soywiz.korge.input.*
import fight.Fight
import com.soywiz.korge.view.Container
import fight.SelectEnemyCallback
import view.BitmapRegistry

class EnemiesView(fight: Fight, bitmapRegistry: BitmapRegistry) : Container() {
    var selecting = false
    var enemySelectedCallback: SelectEnemyCallback? = null

    init {
        var x = 0.0
        fight.enemies.forEach { enemy ->
            val view = EnemyView(enemy, bitmapRegistry)
            view.x = x; x += view.scaledWidth * 1.2
            view.onClick { enemyClicked(view) }
            view.onOver { view.highlight() }
            view.onOut { view.unHighlight() }
            addChild(view)
        }
    }


    fun enemyClicked(enemyView: EnemyView) {
        enemySelectedCallback?.onSelected(enemyView.enemy)
        removeSelectingState()
    }

    fun zoomIn(enemyView: EnemyView) {

    }

    fun zoomOut(enemyView: EnemyView) {

    }

    fun setSelectingState(callback: SelectEnemyCallback) {
        selecting = true
        enemySelectedCallback = callback
    }

    fun removeSelectingState() {
        selecting = false
//        originView = null
    }

}