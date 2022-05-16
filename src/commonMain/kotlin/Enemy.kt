class Enemy( var hp: Int, private val baseStrength: Int) {

    private val listeners = mutableListOf<EnemyDiedListener>()

    fun attack(fight: Fight){
        fight.player.hitFor(baseStrength)
    }

    fun hitFor(dmg: Int){
        this.hp -= dmg
        if( this.hp <= 0){
            this.listeners.forEach { listener->listener.onEnemyDied(this) }
        }
    }

    fun addListener(enemyDiedListener: EnemyDiedListener){
        this.listeners.add(enemyDiedListener)
    }

}

