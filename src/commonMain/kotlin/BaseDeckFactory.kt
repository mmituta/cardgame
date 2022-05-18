import cards.RoundSlash
import cards.SlashCard

class BaseDeckFactory {
    fun createDeck(size: Int): Deck {
        val deck = Deck()

        for (i in 0 until size) {
            deck.add(SlashCard())
            deck.add(RoundSlash())
        }
        return deck
    }
}
