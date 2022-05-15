package view.fight

import Fight
import FightController
import Hand
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.Views
import view.BitmapRegistry
import view.CardView
import view.fight.enemy.EnemiesView
import view.fight.hand.HandView


class FightView(fight: Fight, private val views: Views, private val bitmapRegistry: BitmapRegistry) : Container() {
    private val handView = HandView(bitmapRegistry)

    init {
        val background = Image(bitmapRegistry.getBackground())
        addChild(background)
        background.smoothing = false
        background.scaledWidth = views.virtualWidthDouble
        background.scaledHeight = views.virtualHeightDouble * 2 /3
        val deckView = DeckView(fight.deck)
        addChild(deckView)
        deckView.x = 20.0
        deckView.y = views.virtualHeightDouble - 200

        val turnView = TurnView(fight)
        addChild(turnView)
        turnView.x = views.virtualWidthDouble / 2
        val playerView = PlayerView(fight.player, bitmapRegistry)
        playerView.y = views.virtualHeightDouble /2 - playerView.scaledHeight
        playerView.x = 50.0
        addChild(playerView)

        addChild(handView)


        val enemyView = EnemiesView(fight.enemies, bitmapRegistry)
        enemyView.x = views.virtualWidthDouble - enemyView.scaledWidth - 50
        enemyView.y = views.virtualHeightDouble/ 2 - enemyView.scaledHeight
        addChild(enemyView)
    }

    fun drawHand(hand: Hand){
        handView.setHand(hand)
        handView.y = views.virtualHeightDouble - handView.scaledHeight - 20
        handView.x = views.virtualWidthDouble/2 - handView.scaledWidth /2
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