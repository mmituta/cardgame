package view

import Enemy
import com.soywiz.korge.view.*
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class EnemyView(enemy: Enemy) : Container() {
    init {
        val image = Image(enemy.bitmap).scale(0.2)

        addChild(image);
        val centerX = getBounds().width / 2
        val hp = Text("hp: " + enemy.hp.toString(), 16.0, Colors.WHITE)
        hp.x = centerX
        hp.y = 0.0

        image.y = hp.height + 10
        addChild(hp)
    }
}