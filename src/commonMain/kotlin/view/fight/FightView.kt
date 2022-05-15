package view.fight

import Fight
import FightController
import Hand
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Views
import view.BitmapRegistry
import view.CardView
import view.fight.enemy.EnemiesView
import view.fight.hand.HandView


class FightView(fight: Fight, private val views: Views, private val bitmapRegistry: BitmapRegistry) : Container() {
    private val handView = HandView(bitmapRegistry)

    init {
        val deckView = DeckView(fight.deck)
        addChild(deckView)
        deckView.x = 20.0
        deckView.y = views.virtualHeightDouble - 200

        val turnView = TurnView(fight)
        addChild(turnView)
        turnView.x = views.virtualWidthDouble / 2
        addChild(PlayerView(fight.player, bitmapRegistry))

        addChild(handView)


        val enemyView = EnemiesView(fight.enemies, bitmapRegistry)
        enemyView.x = views.virtualWidthDouble - enemyView.scaledWidth - 50
        addChild(enemyView)
    }

    fun drawHand(hand: Hand){
        handView.setHand(hand)
        handView.y = views.virtualHeightDouble - handView.height - 20
    }

    fun addCardPlayedListener(cardPlayedListener: FightController){
        handView.addCardPlayedListener(cardPlayedListener)
        val view = EndTurnView(cardPlayedListener, bitmapRegistry)
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