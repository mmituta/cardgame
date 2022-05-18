package fight

import Attack

class Enemy(hp: Int, private val attack: Attack, ) : Fighter {

    private var hitListener: HitListener? = null
    val health = Health(hp)
    private val listeners = mutableListOf<EnemyDiedListener>()

    fun attack(fight: Fight) {
        fight.player.hit(attack)
    }

    fun setHitListener(listener: HitListener){
        this.hitListener = listener
    }
    override fun isDead(): Boolean {
        return health.isEmpty()
    }

    override fun hit(attack: Attack) {
        hitListener?.onHit(attack)
        health.hitFor(attack.strength)
        if (health.isEmpty()) {
            this.listeners.forEach { listener -> listener.onEnemyDied(this) }
        }
    }

    fun addListener(enemyDiedListener: EnemyDiedListener) {
        this.listeners.add(enemyDiedListener)
    }

}

