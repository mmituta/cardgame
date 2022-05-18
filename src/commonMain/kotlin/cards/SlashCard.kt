package cards

import Attack
import fight.Enemy
import fight.Fight

class SlashCard : Card(2, "Slash", "Deals 2 damage to selected enemy") {
    override fun play(fight: Fight): Boolean {
        if (fight.enemies.isEmpty()) {
            return false
        }
        val enemy: Enemy? = fight.selectEnemy()
        enemy?.hit(Attack("Slash", 2))

        return true
    }
}