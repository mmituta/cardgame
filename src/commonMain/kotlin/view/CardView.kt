package view

import cards.Card
import com.soywiz.korge.view.*

import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle


class CardView(val card: Card, bitmapRegistry: BitmapRegistry) : Container(){
    init {
        addChild(createBackground(bitmapRegistry.getCard()))
        addChild(createCostText())
        addChild(createNameText())
        addChild(createDescriptionText())
    }

    private fun createBackground(cardBitmap: Bitmap): Image {
        val background = Image(cardBitmap)
        background.smoothing = false
        return background
    }

    private fun createDescriptionText(): Text {
        val description = Text(card.description, 8.0)
        description.setTextBounds(Rectangle(0.0, 0.0, 94.0, 23.0))

        description.x = 8.0
        description.y = 105.0
        return description
    }

    private fun createNameText(): Text {
        val name = Text(card.name, 12.0)
        name.alignment = TextAlignment.MIDDLE_CENTER
        name.setTextBounds(Rectangle(0.0, 0.0, 94.0, 13.0))
        name.x = 8.0
        name.y = 22.0
        return name
    }

    private fun createCostText(): Text {
        val cost = Text(card.cost.toString(), 11.5)
        cost.alignment = TextAlignment.MIDDLE_CENTER
        cost.setTextBounds(Rectangle(0.0, 0.0, 15.0, 15.0))
        cost.x = 7.0
        cost.y = 10.5
        return cost
    }


}