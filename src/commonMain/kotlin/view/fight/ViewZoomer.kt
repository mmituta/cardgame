package view.fight

import com.soywiz.korge.view.View
import com.soywiz.korge.view.bringToTop
import kotlin.math.max
import view.CardView

class ViewZoomer(private val cardView: View, private val zoomLevel: Double = 1.5) {
    private var cardX: Double? = null
    private var cardY: Double? = null
    private var cardScale: Double? = null
    private var zIndex: Int? = null

    fun zoomIn() {
        cardX = cardView.x
        cardY = cardView.y
        cardScale = cardView.scale

        cardView.x = scaleX()
        cardView.y = scaleY()
        cardView.scale *= zoomLevel
        zIndex = cardView.index
        cardView.bringToTop()
    }

    private fun scaleX(): Double {
        return max(0.0, scale(cardView.x, cardView.scaledWidth))
    }

    private fun scaleY(): Double {
        return scale(cardView.y, cardView.scaledHeight)
    }

    private fun scale(value: Double, dimension: Double): Double {
        return value - (dimension * zoomLevel - dimension)
    }

    fun zoomOut() {
        if (cardX != null && cardY != null && cardScale != null) {
            cardView.x = cardX!!
            cardView.y = cardY!!
            cardView.scale = cardScale!!
            cardView.parent?.moveChildTo(cardView, zIndex!!)
        }
    }
}