package view

import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.Text
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle

class ButtonView(text: String, bitmap: Bitmap) : Container() {
    init {
        addChild(Image(bitmap))
        val textView = Text(text, 8.0)
        textView.alignment = TextAlignment.MIDDLE_CENTER
        textView.setTextBounds(Rectangle(0,0, 45, 20))
        addChild(textView)
        scale = 4.0
    }
}