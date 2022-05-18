package view.fight

import fight.Fight
import fight.FightController
import fight.Hand
import com.soywiz.korge.view.*
import com.soywiz.korge.view.filter.BlurFilter
import view.BitmapRegistry
import view.CardView
import view.fight.enemy.EnemiesView
import view.fight.hand.HandView


private const val BOTTOM_PADDING = 20

class FightView(fight: Fight, private val views: Views, private val bitmapRegistry: BitmapRegistry) : Container() {
    private val handView = HandView(bitmapRegistry)
    private val battleContainer = Container()
    private val overlayView = OverlayView(views)
    init {
        addChild(battleContainer)
        battleContainer.addChild(createBackground())


        battleContainer.addChild(createPlayersView(fight))
        battleContainer.addChild(createEnemiesView(fight))

        battleContainer.addChild(handView)
        val view = ApView(fight)
        view.y = views.virtualHeightDouble * 2 / 3
        battleContainer.addChild(view)

        val deckView = PileView(fight.deck, bitmapRegistry)
        battleContainer.addChild(deckView)
        deckView.y = views.virtualHeightDouble - deckView.scaledHeight - BOTTOM_PADDING

        battleContainer.addChild(TopBarView(views, fight))

        addChild(overlayView)
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
        val enemyView = EnemiesView(fight, bitmapRegistry)
        enemyView.x = views.virtualWidthDouble - enemyView.scaledWidth - 50
        enemyView.y = views.virtualHeightDouble / 2 - enemyView.scaledHeight
        return enemyView
    }

    fun drawHand(hand: Hand){
        handView.setHand(hand)
        handView.y = views.virtualHeightDouble - handView.scaledHeight - BOTTOM_PADDING
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

    fun onFightWon() {
        battleContainer.filter = BlurFilter(10.0)
        overlayView.setMessage("Victory")
    }

    fun onFightLost() {
        battleContainer.filter = BlurFilter(10.0)
        overlayView.setMessage("You lost")
    }

}