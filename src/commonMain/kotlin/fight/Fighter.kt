package fight

import Attack

interface Fighter {
    fun isDead(): Boolean
    fun hit(attack: Attack)
}