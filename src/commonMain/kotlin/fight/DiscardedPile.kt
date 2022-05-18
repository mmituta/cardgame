package fight

import cards.Card
// TODO: refactor this and deck as "piles"
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