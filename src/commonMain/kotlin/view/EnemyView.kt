package view

import Enemy
import com.soywiz.korge.view.Circle
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Text
import com.soywiz.korim.color.Colors

class EnemyView (enemy: Enemy): Container(){
    init {
        addChild(Circle(50.0, Colors.PINK))
        val centerX = getBounds().width/2
        val centerY = getBounds().height/2
        val hp = Text("hp: " + enemy.hp.toString(), 16.0, Colors.BLACK)
        hp.x = centerX
        hp.y = centerY
        addChild(hp)
    }
}