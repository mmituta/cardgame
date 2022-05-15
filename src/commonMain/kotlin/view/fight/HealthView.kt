package view.fight

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle

private const val WIDTH = 200.0
private const val HEIGHT = 50.0

private const val TEXT_SIZE = 20.0

class HealthView(private val maxHp: Int, var currentHp:Int = maxHp) : Container() {

    init {
        addChild(createBackground())
        val health = rectangleOfColor(Colors.RED)
        addChild(health)
        addChild(createBorder())

        val text = createHpText()
        text.y = health.scaledHeight + 5
        addChild(text)

        addUpdater {
            text.text = formatHpText()
            health.scaledWidth = WIDTH * currentHp / maxHp
        }
    }

    private fun rectangleOfColor(color: RGBA): RoundRect{
        return RoundRect(WIDTH, HEIGHT, 0.0, 0.0, color, color)

    }
    private fun createBorder(): RoundRect {
        val border = RoundRect(WIDTH, HEIGHT, 0.0, 0.0, Colors.TRANSPARENT_WHITE)
        border.strokeThickness = 5.0
        return border
    }

    private fun createBackground(): RoundRect {
        return rectangleOfColor(Colors.BLACK)
    }

    private fun createHpText(): Text {
        val text = Text(formatHpText(), TEXT_SIZE)
        text.alignment = TextAlignment.MIDDLE_CENTER
        text.setTextBounds(Rectangle(0.0, 0.0, WIDTH, TEXT_SIZE))
        return text
    }

    private fun formatHpText() = "$currentHp/$maxHp"

}