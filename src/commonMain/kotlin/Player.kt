class Player (var hp: Int, val ap: Int) {
    fun hitFor(dmg: Int) {
        this.hp -= dmg
    }
}
