package cards

import Attack
import fight.Fight

class SlashCard : Card(2, "Slash", "Deals 2 damage to selected enemy") {
    override fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback) {
        if (fight.enemies.isNotEmpty()) {
            fight.selectEnemy { enemy ->
                enemy.hit(Attack("Slash", 2))
                cardPlayedCallback.onCardPlayed()
            }

        }
    }
}