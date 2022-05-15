package view.fight.hand

import com.soywiz.korge.view.bringToTop
import kotlin.math.max
import view.CardView

class CardZoomer(private val cardView: CardView, private val zoomLevel: Double = 1.5) {
    private var cardX: Double? = null
    private var cardY: Double? = null
    private var cardScale: Double? = null


    fun zoomIn() {
        cardX = cardView.x
        cardY = cardView.y
        cardScale = cardView.scale

        cardView.x = scaleX()
        cardView.y = scaleY()
        cardView.scale *= zoomLevel
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
        }
    }
}