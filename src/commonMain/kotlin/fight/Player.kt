package fight

class Player ( hp: Int, val ap: Int): Fighter {
    val health: Health = Health(hp)

    override fun hitFor(dmg: Int) {
        health.hitFor(dmg)
    }

    override fun isDead() = health.isEmpty()

}
