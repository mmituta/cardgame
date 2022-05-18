package cards

import Attack
import fight.Enemy
import fight.Fight

class RoundSlash : Card(3, "Round slash", "Attacks all enemies for 3 DMG") {
    override fun play(fight: Fight): Boolean {
        if (fight.enemies.isEmpty()) {
            return false
        }
        fight.enemies.forEach { enemy: Enemy ->
            enemy.hit(Attack("Slash", 3))
        }
        return true
    }
}