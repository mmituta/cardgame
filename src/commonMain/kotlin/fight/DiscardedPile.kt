package fight

import Card

class DiscardedPile {

    val cards = mutableListOf<Card>()

    fun addCard(card: Card){
        cards.add(card)
    }

    fun clearAndReturnAll(): Collection<Card>{
        val toReturn = cards.toList()
        cards.clear()

        return toReturn
    }

    fun addAll(toAdd: Collection<Card>) {
        cards.addAll(toAdd)
    }
}