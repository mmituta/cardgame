package fight

interface EnemyProvider {

    fun selectEnemy(callback: SelectEnemyCallback)
}