import kotlin.random.Random

class Deck {
    private val deck = mutableListOf<Card>()
    fun add(card: Card) {
        deck.add(card)
    }

    fun drawCardAt(nextInt: Int): Card {
        return deck.removeAt(nextInt)
    }

    fun size(): Int {
        return deck.size
    }

    fun drawHand(number: Int): Hand{
        val hand = mutableListOf<Card>()
        for(i in 0 until number){
            hand.add(drawCardAt(Random.nextInt(0, deck.size)))
        }

        return Hand(hand)
    }
}
