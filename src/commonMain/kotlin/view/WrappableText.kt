package view

import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.font.DefaultTtfFont
import com.soywiz.korim.font.Font
import com.soywiz.korim.text.TextAlignment
import com.soywiz.korim.text.TextRenderer
import com.soywiz.korim.text.TextRendererActions
import com.soywiz.korio.resources.Resourceable

enum class Gravity {
    LEFT, CENTER, RIGHT
}


class WrappableText(
    text: String,
    textSize: Double = DEFAULT_TEXT_SIZE,
    color: RGBA = Colors.WHITE, font: Resourceable<out Font> = DefaultTtfFont,
    alignment: TextAlignment = TextAlignment.TOP_LEFT
) : Text(text, textSize, color, font, alignment) {
    init {
        renderer = WrappableTextRenderer(this, Gravity.CENTER)
        autoScaling = true
    }
}

class WrappableTextRenderer(val view: Text, private val gravity: Gravity) : TextRenderer<String> {
    override fun TextRendererActions.run(text: String, size: Double, defaultFont: Font) {
        setFont(defaultFont, size)

        val lines = mutableListOf(Line())
        val spaceWidth = getGlyphMetrics(' '.code).xadvance + getKerning(' '.code, 'A'.code)

        val left = view.localToGlobalX(0.0, 0.0)
        val right = view.localToGlobalX(view.width, 0.0)
        val scaledWidth = right - left
        for (wrapped in text.split('\n')) {
            var curX = 0.0
            for (word in wrapped.split(' ')) {
                var wordWidth = 0.0
                var curWord = ""
                for (n in word.indices) {
                    val c = word[n].code
                    val c1 = word.getOrElse(n + 1) { '\u0000' }.code

                    val g = getGlyphMetrics(c)
                    val kerning = getKerning(c, c1)
                    val charWidth = g.xadvance + kerning

                    if (wordWidth + charWidth + spaceWidth > scaledWidth) {
                        // Wrap inside the word
                        val word1 = Word(curWord, wordWidth)
                        if (lines.last().words.isEmpty()) {
                            lines.last().words.add(word1)
                        } else {
                            lines.add(Line(mutableListOf(word1)))
                        }
                        curX = 0.0
                        wordWidth = 0.0
                        curWord = ""
                        lines.add(Line())
                    }

                    wordWidth += charWidth
                    curWord += c.toChar()
                }

                curX += wordWidth + spaceWidth

                if (curX > scaledWidth) {
                    lines.add(Line())
                    curX = wordWidth + spaceWidth
                }

                lines.last().words.add(Word(curWord, wordWidth))
            }
            lines.add(Line())
        }

        for (line in lines) {
            var start =
                when (gravity) {
                    Gravity.LEFT -> 0.0
                    Gravity.CENTER -> (scaledWidth - line.calculateWidth(spaceWidth)) / 2
                    Gravity.RIGHT -> scaledWidth - line.calculateWidth(spaceWidth)
                }

            for (word in line.words) {
                x = start

                for (n in word.text.indices) {
                    val c = word.text[n].code
                    val c1 = word.text.getOrElse(n + 1) { '\u0000' }.code

                    val g = getGlyphMetrics(c)
                    transform.identity()

                    val advance = g.xadvance + getKerning(c, c1)

                    put(c)
                    advance(advance)
                }

                start += word.width + spaceWidth
            }

            newLine(lineHeight)
        }

        put(0)
    }

    private data class Line(
        val words: MutableList<Word> = mutableListOf()
    ) {
        fun calculateWidth(spaceWidth: Double): Double {
            return words.sumOf { it.width } + (words.size - 1) * spaceWidth
        }
    }

    private data class Word(val text: String, val width: Double)
}