package view.fight.effects

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.sprite
import com.soywiz.korim.bitmap.Bitmap

abstract class AbstractEffectView(bitmap: Bitmap) : Container() {
    private val explosionAnimation = com.soywiz.korge.view.SpriteAnimation(
        spriteMap = bitmap,
        spriteWidth = 512,
        spriteHeight = 512,
        marginTop = 0,
        marginLeft = 0,
        columns = 4,
        rows = 4,
        offsetBetweenColumns = 0,
        offsetBetweenRows = 0,
    )

    private val effect = sprite(explosionAnimation)


    fun play(){
        effect.onAnimationCompleted.add {
            removeFromParent()
        }
        effect.playAnimation()
    }

}