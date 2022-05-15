package view

import Fight
import FightController
import Hand
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Views
import com.soywiz.korim.bitmap.Bitmap
import view.hand.HandView


class FightView(fight: Fight, private val views: Views, cardBitmap: Bitmap, private val buttonBitmap: Bitmap) : Container() {
    private val handView = HandView(cardBitmap)

    init {
        val deckView = DeckView(fight.deck)
        addChild(deckView)
        deckView.x = 20.0
        deckView.y = views.virtualHeightDouble - 200

        val turnView = TurnView(fight)
        addChild(turnView)
        turnView.x = views.virtualWidthDouble / 2

        addChild(handView)

        addChild(PlayerView(fight.player))

        val enemyView = EnemiesView(fight.enemies)
        enemyView.x = views.virtualWidthDouble - 150
        addChild(enemyView)
    }

    fun drawHand(hand: Hand){
        handView.setHand(hand)
        handView.y = views.virtualHeightDouble - handView.height - 20
    }

    fun addCardPlayedListener(cardPlayedListener: FightController){
        handView.addCardPlayedListener(cardPlayedListener)
        val view = EndTurnView(cardPlayedListener, buttonBitmap)
        view.x = views.virtualWidthDouble / 2
        view.y = 150.0
        addChild(view)
    }

    fun removeCardPlayedListener(cardPlayedListener: FightController){
        handView.removeCardPlayedListener(cardPlayedListener)
    }

    fun removeFromHand(card: CardView) {
        handView.removeCard(card)
    }

}