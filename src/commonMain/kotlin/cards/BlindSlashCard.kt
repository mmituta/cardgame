package cards

import Attack
import fight.Enemy
import fight.Fight
import kotlin.random.Random

class BlindSlashCard: Card(1, "Blind slash", "Attacks a random enemy for 3 DMG") {
    override fun play(fight: Fight): Boolean {
        if( fight.enemies.isEmpty()){
            return false
        }
        fight.enemies[getEnemyIndex(fight.enemies)].hit(Attack("Slash", 3))
        return true
    }

    private fun getEnemyIndex(enemies: List<Enemy>): Int {
        if (enemies.size <= 1) {
            return 0
        }

        return Random.nextInt(0, enemies.size)
    }
}