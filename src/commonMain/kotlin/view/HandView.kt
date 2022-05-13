package view

import CardViewListener
import Hand
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.Container
import com.soywiz.korim.bitmap.Bitmap

class HandView(private val cardBitmap: Bitmap) : Container() {
    val cardListeners = mutableListOf<CardViewListener>()


    fun setHand(hand: Hand){
        children.clear()
        var x = 0.0
        for( card in hand.cards()){
            val view = CardView(card, cardBitmap)
            view.x = x
            addChild(view)
            x += view.width * 0.8
            view.onClick {
                cardListeners.forEach { listener -> listener.onHandCardTouched(view) }
            }
        }
    }


    fun addCardPlayedListener(cardListener: CardViewListener){
        cardListeners.add(cardListener)
    }


    fun removeCardPlayedListener(cardListener: CardViewListener){
        cardListeners.remove(cardListener)
    }

    fun removeCard(card: CardView) {
        children.remove(card)
    }
}