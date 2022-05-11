class Hand(cards: List<Card> = emptyList()) {
    private var cards: MutableList<Card>

    init {
        this.cards = cards.toMutableList()
    }

    fun getAndRemoveCardAt(index: Int): Card {
        return this.cards.removeAt(index)
    }

    fun removeCard(card: Card){
        this.cards.remove(card)
    }

    fun cards(): List<Card>{
        return this.cards.toList()
    }
}