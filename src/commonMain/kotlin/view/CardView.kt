package view

import Card

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.Text
import com.soywiz.korim.bitmap.Bitmap

class CardView(card: Card, cardBitmap: Bitmap) : Container(){
    init {

        val cost = Text(card.cost.toString())
        cost.x = 12.0
        cost.y = 10.0

        val name = Text(card.name)
        name.x = 30.0
        name.y = 99.0
        addChild(Image(cardBitmap))
        addChild(cost)
        addChild(name)


    }



}