import cards.RoundSlash
import cards.BlindSlashCard
import cards.SlashCard

class BaseDeckFactory {
    fun createDeck(size: Int): Deck {
        val deck = Deck()

        for (i in 0 until size) {
            deck.add(BlindSlashCard())
            deck.add(RoundSlash())
            deck.add(SlashCard())
        }
        return deck
    }
}
