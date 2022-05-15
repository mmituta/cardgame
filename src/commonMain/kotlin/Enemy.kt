import com.soywiz.korim.bitmap.Bitmap

class Enemy( var hp: Int, private val baseStrength: Int,  val bitmap: Bitmap) {

    private val listeners = mutableListOf<EnemyDiedListener>()

    fun attack(): Int{
        return baseStrength
    }

    fun hitFor(dmg: Int){
        this.hp -= dmg
        this.listeners.forEach { listener->listener.onEnemyDied(this) }
    }

    fun addListener(enemyDiedListener: EnemyDiedListener){
        this.listeners.add(enemyDiedListener)
    }

}

