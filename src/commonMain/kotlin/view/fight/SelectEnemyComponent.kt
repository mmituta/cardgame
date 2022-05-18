package view.fight

import com.soywiz.korev.MouseEvent
import com.soywiz.korge.baseview.BaseView
import com.soywiz.korge.component.MouseComponent
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Line
import com.soywiz.korge.view.Views
import com.soywiz.korma.geom.Point

class SelectEnemyComponent(origin: Point, override val view: Container) : MouseComponent {
    private val line = Line(origin.x, origin.y, origin.x, origin.y)
    init {
        view.addChild(line)
    }
    override fun onMouseEvent(views: Views, event: MouseEvent) {
        if (event.typeMove) {
            line.x2 = views.stage.mouseX
            line.y2 = views.stage.mouseY
        }
    }
}