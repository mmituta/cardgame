package cards

import Attack
import fight.Fight

class SlashCard : Card{
    override val cost = 2
    override val name = "Slash"
    override val description = "Deals 2 damage to selected enemy"

    override fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback) {
        if (fight.enemies.isNotEmpty()) {
            fight.selectEnemy { enemy ->
                enemy.hit(Attack("Slash", 2))
                cardPlayedCallback.onCardPlayed()
            }

        }
    }
}