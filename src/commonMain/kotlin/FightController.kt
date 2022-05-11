import view.FightView

class FightController(val fightView: FightView, val fight: Fight) : CardPlayedListener {


    init {
        fightView.addCardPlayedListener(this)
    }

    fun startTurn(){
        fight.startTurn()
        fightView.drawHand(fight.drawHand(5))
    }

    override fun onCardPlayed(card: Card) {
        fight.playCard(card)
        println("card played "+ card.name)
    }
}