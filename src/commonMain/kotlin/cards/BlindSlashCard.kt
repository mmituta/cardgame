package cards

import Attack
import fight.Enemy
import fight.Fight
import kotlin.random.Random

class BlindSlashCard : Card{
    override val cost: Int = 1
    override val name: String = "Blind slash"
    override val description: String = "Attacks a random enemy for 3 DMG"

    override fun play(fight: Fight, cardPlayedCallback: CardPlayedCallback) {
        if (fight.enemies.isNotEmpty()) {
            fight.enemies[getEnemyIndex(fight.enemies)].hit(Attack("Slash", 3))
            cardPlayedCallback.onCardPlayed()
        }
    }

    private fun getEnemyIndex(enemies: List<Enemy>): Int {
        if (enemies.size <= 1) {
            return 0
        }

        return Random.nextInt(0, enemies.size)
    }
}