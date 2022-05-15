package view.hand

import com.soywiz.korge.view.bringToTop
import kotlin.math.max
import view.CardView

class CardZoomer(private val cardView: CardView, private val zoomLevel: Double = 1.5) {
    var cardX = 0.0
    var cardY = 0.0

    init {
        cardX = cardView.x
        cardY = cardView.y
    }

    fun zoomIn() {
        cardX = cardView.x
        cardY = cardView.y
        cardView.scale = zoomLevel
        cardView.x = scaleX()
        cardView.y = scaleY()
        cardView.bringToTop()
    }

    private fun scaleX(): Double {
        return max(0.0, scale(cardView.x, cardView.width))
    }

    private fun scaleY(): Double {
        return scale(cardView.y, cardView.height)
    }

    private fun scale(value: Double, dimension: Double): Double {
        return value - (dimension * zoomLevel - dimension)
    }

    fun zoomOut() {
        cardView.scale = 1.0
        cardView.x = cardX
        cardView.y = cardY
    }
}