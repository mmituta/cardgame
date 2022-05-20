package cards
import fight.Fight

abstract class Card(val cost: Int, val name: String, val description: String = "") {
    abstract fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback)
}
