package fight

import Attack

class Player(hp: Int, val ap: Int) : Fighter {
    val health: Health = Health(hp)
    private var hitListener: HitListener? = null
    override fun isDead() = health.isEmpty()
    override fun hit(attack: Attack) {
        hitListener?.onHit(attack)
        health.hitFor(attack.strength)
    }

    fun setHitListener(hitListener: HitListener){
        this.hitListener = hitListener
    }

}
