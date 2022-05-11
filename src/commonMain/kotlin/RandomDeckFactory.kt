import kotlin.random.Random

class RandomDeckFactory {
    fun createDeck(size: Int): Deck {
        val deck = Deck()

        for (i in 0 until size) {
            deck.add(Card(Random.nextInt(0, 3), "Name $i"))
        }
        return deck
    }
}
