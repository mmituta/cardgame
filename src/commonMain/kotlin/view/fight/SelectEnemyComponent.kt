package view.fight

import com.soywiz.korev.MouseEvent
import com.soywiz.korge.component.MouseComponent
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors

class SelectEnemyComponent(origin: View, override val view: Container) : MouseComponent {
    private val line = Line(0.0, 0.0, origin.x, origin.y, Colors.RED)

    init {

        view.addChild(line)
        line.centerOn(origin)
        line.x2 = line.x
        line.y2 = line.y
    }

    override fun onMouseEvent(views: Views, event: MouseEvent) {
        if (event.typeMove) {
            line.x2 = view.localMouseX(views)
            line.y2 = view.localMouseY(views)
        }
    }

    fun clear() {
        view.removeChild(line)
    }
}