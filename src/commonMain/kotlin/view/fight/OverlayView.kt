package view.fight

import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle

class OverlayView(views: Views) : Container() {

    private val messageView = Text("", 100.0, Colors.BLACK)
    private val background = RoundRect(views.virtualWidthDouble, views.virtualHeightDouble, 0.0, 0.0)

    init {
        background.alpha = 0.0

        messageView.setTextBounds(Rectangle(0.0,0.0, views.virtualWidthDouble, views.virtualHeightDouble))
        messageView.alignment = TextAlignment.MIDDLE_CENTER
        addChild(background)
        addChild(messageView)
    }

    fun setMessage(message: String) {
        bringToTop()
        background.alpha = 0.4
        messageView.text = message
    }
}