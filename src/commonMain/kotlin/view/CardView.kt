package view

import Card
import com.soywiz.korge.view.*

import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle

private const val SCALE = 3.5

class CardView(val card: Card, cardBitmap: Bitmap) : Container(){
    init {

        val cost = Text(card.cost.toString(), 11.5 * SCALE)
        cost.alignment = TextAlignment.MIDDLE_CENTER
        cost.setTextBounds(Rectangle(0.0, 0.0, 15 * SCALE, 15 * SCALE))
        cost.x = 7 * SCALE
        cost.y = 10.5 * SCALE

        val name = Text(card.name, 12.0 * SCALE)
        name.alignment = TextAlignment.MIDDLE_CENTER
        name.setTextBounds(Rectangle(0.0, 0.0, 94.0*SCALE, 13.0*SCALE))
        name.x = 8.0 * SCALE
        name.y = 22.0 * SCALE

        val description = Text(card.description, 8.0 * SCALE)
        description.setTextBounds(Rectangle(0.0, 0.0, 94.0 * SCALE, 23.0 * SCALE))

        description.x = 8.0 * SCALE
        description.y = 105.0 * SCALE
        val background = Image(cardBitmap)
        background.smoothing = false
        background.scale(SCALE)
        addChild(background)
        addChild(cost)
        addChild(name)
        addChild(description)


    }



}