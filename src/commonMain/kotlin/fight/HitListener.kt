package fight

import Attack

interface HitListener {
    fun onHit(attack: Attack)
}