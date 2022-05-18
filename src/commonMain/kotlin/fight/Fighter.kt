package fight

interface Fighter {
    fun hitFor(dmg: Int)
    fun isDead(): Boolean
}