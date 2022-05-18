import fight.Enemy
import fight.Fight
import kotlin.random.Random

data class Card(val cost: Int, val name: String, val description: String = "") {
    fun play(fight: Fight): Boolean {
        if( fight.enemies.isEmpty()){
            return false
        }
        fight.enemies[getEnemyIndex(fight.enemies)].hitFor(3)
        return true
    }

    private fun getEnemyIndex(enemies: List<Enemy>): Int {
        if (enemies.size <= 1) {
            return 0
        }

        return Random.nextInt(0, enemies.size)
    }
}
