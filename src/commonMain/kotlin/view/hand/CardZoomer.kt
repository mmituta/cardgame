package view.hand

import com.soywiz.korge.view.bringToTop
import kotlin.math.max
import view.CardView

class CardZoomer(private val cardView: CardView, private val zoomLevel: Double = 1.5) {
    private var cardX = 0.0
    private var cardY = 0.0
   private  var cardScale = 1.0


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
        cardView.x = cardX
        cardView.y = cardY
        cardView.scale = cardScale
    }
}