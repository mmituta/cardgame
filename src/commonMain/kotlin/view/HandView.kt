package view

import CardPlayedListener
import Hand
import com.soywiz.korge.input.onClick
import com.soywiz.korge.view.Container

class HandView : Container() {
    val cardListeners = mutableListOf<CardPlayedListener>()


    fun setHand(hand: Hand){
        children.clear()
        var x = 0.0;
        for( card in hand.cards()){
            val view = CardView(card)
            view.x = x
            addChild(view)
            x += view.width * 1.2
            view.onClick {
                cardListeners.forEach { listener -> listener.onCardPlayed(card) }
                view.removeFromParent()
            }
        }
    }


    fun addCardPlayedListener(cardListener: CardPlayedListener){
        cardListeners.add(cardListener)
    }


    fun removeCardPlayedListener(cardListener: CardPlayedListener){
        cardListeners.remove(cardListener)
    }
}