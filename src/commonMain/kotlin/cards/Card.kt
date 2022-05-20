package cards
import fight.Fight

interface Card {
    val cost: Int
    val name: String
    val description: String
    fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback)
}
