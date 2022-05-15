package view.fight

import Fight
import FightController
import Hand
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.Views
import view.BitmapRegistry
import view.CardView
import view.fight.enemy.EnemiesView
import view.fight.hand.HandView


class FightView(fight: Fight, private val views: Views, private val bitmapRegistry: BitmapRegistry) : Container() {
    private val handView = HandView(bitmapRegistry)

    init {
        addChild(createBackground())
        val deckView = DeckView(fight.deck)
        addChild(deckView)
        deckView.x = 20.0
        deckView.y = views.virtualHeightDouble - 200


        addChild(createPlayersView(fight))
        addChild(createEnemiesView(fight))

        addChild(handView)

        addChild(TopBarView(views, fight))
    }

    private fun createBackground(): Image {
        val background = Image(bitmapRegistry.getBackground())

        background.smoothing = false
        background.scaledWidth = views.virtualWidthDouble
        background.scaledHeight = views.virtualHeightDouble * 2 / 3
        return background
    }

    private fun createPlayersView(fight: Fight): PlayerView {
        val playerView = PlayerView(fight.player, bitmapRegistry)
        playerView.y = views.virtualHeightDouble / 2 - playerView.scaledHeight
        playerView.x = 50.0
        return playerView
    }

    private fun createEnemiesView(fight: Fight): EnemiesView {
        val enemyView = EnemiesView(fight.enemies, bitmapRegistry)
        enemyView.x = views.virtualWidthDouble - enemyView.scaledWidth - 50
        enemyView.y = views.virtualHeightDouble / 2 - enemyView.scaledHeight
        return enemyView
    }

    fun drawHand(hand: Hand){
        handView.setHand(hand)
        handView.y = views.virtualHeightDouble - handView.scaledHeight - 20
        handView.x = views.virtualWidthDouble/2 - handView.scaledWidth /2
    }

    fun addCardPlayedListener(cardPlayedListener: FightController){
        handView.addCardPlayedListener(cardPlayedListener)
        val view = EndTurnView(cardPlayedListener, bitmapRegistry)
        view.x = views.virtualWidthDouble - view.scaledWidth - 5
        view.y = views.virtualHeightDouble - view.scaledHeight - 5
        addChild(view)
    }

    fun removeCardPlayedListener(cardPlayedListener: FightController){
        handView.removeCardPlayedListener(cardPlayedListener)
    }

    fun removeFromHand(card: CardView) {
        handView.removeCard(card)
    }

}