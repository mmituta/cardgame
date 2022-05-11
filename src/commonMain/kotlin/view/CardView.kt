package view

import Card

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.Text
import com.soywiz.korim.color.Colors

class CardView(card: Card) : Container(){
    init {
        val bgField = RoundRect(60.0, 100.0, 5.0, fill = Colors["#FF0000"])

        val cost = Text(card.cost.toString())
        cost.x = 0.0
        cost.y = 0.0

        val name = Text(card.name)
        name.x = 0.0
        name.y = 50.0
        addChild(bgField)
        addChild(cost)
        addChild(name)


    }



}