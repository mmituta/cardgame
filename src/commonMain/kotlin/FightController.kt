import view.CardView
import view.fight.FightView

class FightController(val fightView: FightView, val fight: Fight) : CardViewListener {


    init {
        fightView.addCardPlayedListener(this)
    }


    fun startTurn(){
        fight.startTurn()
        fightView.drawHand(fight.drawHand(5))
    }

    override fun onHandCardTouched(cardView: CardView) {
        val card = cardView.card
        if( fight.ap >= card.cost ){
            fight.playCard(card)
            fightView.removeFromHand(cardView)
        }

    }
}