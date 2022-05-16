package view

import com.soywiz.korim.bitmap.Bitmap

class BitmapRegistry {
    private val map: MutableMap<String, Bitmap> = mutableMapOf()

    fun addPlayer(bitmap: Bitmap){
        map["player"] = bitmap
    }

    fun addBackground(bitmap: Bitmap){
        map["background"] = bitmap
    }


    fun addCard(bitmap: Bitmap){
        map["card"] = bitmap
    }

    fun addButton(bitmap: Bitmap){
        map["button"] = bitmap
    }

    fun addEnemy(bitmap: Bitmap){
        map["enemy"] = bitmap
    }

    fun addCardBack(bitmap: Bitmap){
        map["cardBack"] = bitmap
    }

    fun getPlayer(): Bitmap{
        return map["player"]!!
    }

    fun getCard(): Bitmap{
        return map["card"]!!
    }

    fun getButton(): Bitmap{
        return map["button"]!!
    }

    fun getEnemy(): Bitmap{
        return map["enemy"]!!
    }

    fun getBackground():Bitmap = map["background"]!!
    fun getCardBack(): Bitmap = map["cardBack"]!!
}