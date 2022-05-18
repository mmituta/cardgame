package fight

import view.CardViewListener
import view.CardView
import view.fight.FightView

class FightController(val fightView: FightView, val fight: Fight) : CardViewListener {


    init {
        fightView.addCardPlayedListener(this)
    }


    fun startTurn(){
        fight.startTurn()
        if(fight.deck.size() < 5 ){
            val list = fight.discardedPile.clearAndReturnAll()
            // TODO shuffle
            fight.deck.addAll(list)
        }
        fightView.drawHand(fight.drawHand(5))
    }

    fun endTurn(){
        fight.enemies.forEach { enemy-> enemy.attack(fight) }
        fight.discardedPile.addAll( fight.hand.clearAndReturnAll() )
        if( fight.enemies.isEmpty()){
            fightView.onFightWon()
            println("You won")
        }
        if( fight.player.isDead()){
            fightView.onFightLost()
            println("You lose")
        }
        startTurn()

    }

    override fun onHandCardTouched(cardView: CardView) {
        val card = cardView.card
        if( fight.ap >= card.cost ){
            fight.playCard(card)
            fightView.removeFromHand(cardView)

        }

    }
}