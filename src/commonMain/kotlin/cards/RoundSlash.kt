package cards

import Attack
import fight.Enemy
import fight.Fight

class RoundSlash : Card {
    override val cost = 3
    override val name = "Round slash"
    override val description = "Attacks all enemies for 3 DMG"

    override fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback) {
        if (fight.enemies.isNotEmpty()) {
            fight.enemies.forEach { enemy: Enemy ->
                enemy.hit(Attack("Slash", 3))
                cardPlayedCallback.onCardPlayed()
            }
        }
    }
}