package view.fight.hand

import view.CardViewListener
import fight.Hand
import com.soywiz.korge.input.onClick
import com.soywiz.korge.input.onOut
import com.soywiz.korge.input.onOver
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.bringToTop
import view.BitmapRegistry
import view.CardView
import view.fight.ViewZoomer

class HandView(private val bitmapRegistry: BitmapRegistry) : Container() {
    private val cardListeners = mutableListOf<CardViewListener>()
    var activeCard: CardView? = null

    fun setHand(hand: Hand) {
        removeChildren()
        var x = 0.0
        for (card in hand.cards()) {
            val view = CardView(card, bitmapRegistry)
            view.x = x
            addChild(view)
            view.scale = 3.5
            x += view.scaledWidth * 0.8
            view.onClick {
                if( activeCard == null){
                    activeCard = view
                    cardListeners.forEach { listener -> listener.onHandCardTouched(view) }
                }
            }
            val zoomer = ViewZoomer(view)
            view.onOver {
                if (activeCard == null) {
                    zoomer.zoomIn()
                }
            }
            view.onOut {
                if (activeCard == null) {
                    zoomer.zoomOut()
                }
            }


        }
    }


    fun addCardPlayedListener(cardListener: CardViewListener) {
        cardListeners.add(cardListener)
    }


    fun removeCardPlayedListener(cardListener: CardViewListener) {
        cardListeners.remove(cardListener)
    }

    fun removeCard(card: CardView) {
        removeChild(card)
        activeCard = null
    }
}