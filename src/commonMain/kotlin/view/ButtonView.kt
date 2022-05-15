package view

import com.soywiz.klogger.AnsiEscape
import com.soywiz.korge.input.onOut
import com.soywiz.korge.input.onOver
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.Image
import com.soywiz.korge.view.RoundRect
import com.soywiz.korge.view.Text
import com.soywiz.korge.view.filter.ColorTransformFilter
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.color.ColorAdd
import com.soywiz.korim.color.ColorTransform
import com.soywiz.korim.color.Colors
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korma.geom.Rectangle

class ButtonView(text: String, bitmap: Bitmap) : Container() {
    private val whiteOverlay = RoundRect(45.0, 25.0, 0.0)

    init {
        whiteOverlay.alpha = 0.4
        val background = Image(bitmap)
        addChild(background)
        val textView = Text(text, 8.0)
        textView.alignment = TextAlignment.MIDDLE_CENTER
        textView.setTextBounds(Rectangle(0, 0, 45, 20))
        addChild(textView)
        scale = 4.0

        val colorTransformFilter = ColorTransformFilter(ColorTransform.Add(30, 30, 30, 0) )
        onOver { background.addFilter(colorTransformFilter) }
        onOut { background.removeFilter(colorTransformFilter) }

    }
}