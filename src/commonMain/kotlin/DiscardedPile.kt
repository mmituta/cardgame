class DiscardedPile {

    val cards = mutableListOf<Card>()

    fun addCard(card: Card){
        cards.add(card)
    }

    fun clearAndReturnAll(): Collection<Card>{
        val toReturn = cards.toList()
        cards.clear()

        return toReturn;
    }
}