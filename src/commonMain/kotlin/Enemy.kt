class Enemy(val hp: Int, private val baseStrength: Int) {

    fun attack(): Int{
        return baseStrength
    }

}

