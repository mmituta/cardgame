package fight

class Enemy(hp: Int, private val baseStrength: Int) : Fighter {

    val health = Health(hp)
    private val listeners = mutableListOf<EnemyDiedListener>()

    fun attack(fight: Fight) {
        fight.player.hitFor(baseStrength)
    }

    override fun hitFor(dmg: Int) {
        health.hitFor(dmg)
        if (health.isEmpty()) {
            this.listeners.forEach { listener -> listener.onEnemyDied(this) }
        }
    }

    override fun isDead(): Boolean {
        return health.isEmpty()
    }

    fun addListener(enemyDiedListener: EnemyDiedListener) {
        this.listeners.add(enemyDiedListener)
    }

}

