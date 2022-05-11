import com.soywiz.korim.bitmap.Bitmap

class Enemy(val hp: Int, private val baseStrength: Int,  val bitmap: Bitmap) {

    fun attack(): Int{
        return baseStrength
    }

}

