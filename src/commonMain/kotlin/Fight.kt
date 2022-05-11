class Fight(val player: Player, val enemies: List<Enemy>, val deck: Deck) {
    var hand = Hand()
    var turn = 1
    private val discardedPile = DiscardedPile()
    var ap = 0;
    init {
        ap = player.ap
    }

    fun drawHand(number: Int): Hand{
        hand = deck.drawHand(number)
        return hand
    }

    fun playCard(card: Card){
        hand.removeCard(card)
        ap -= card.cost
        discardedPile.addCard(card)
    }

    fun startTurn(){
        turn += 1
        ap = player.ap
    }
}