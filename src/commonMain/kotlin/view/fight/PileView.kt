package view.fight

import Deck
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import view.BitmapRegistry


private const val MARGIN = 5.0

class PileView(deck: Deck, bitmapRegistry: BitmapRegistry) : Container() {

    init {

        val firstCard = createBackCardImage(bitmapRegistry)
        addChild(RoundRect(firstCard.scaledWidth, firstCard.scaledHeight, 0.0, 0.0 , Colors.TRANSPARENT_WHITE, Colors.WHITE, 2.0))
        addChild(firstCard)
        val secondCard = createBackCardImage(bitmapRegistry)
        secondCard.x = MARGIN
        secondCard.y = -MARGIN
        addChild(secondCard)
        val thirdCard = createBackCardImage(bitmapRegistry)
        thirdCard.x = 2 * MARGIN
        thirdCard.y = -2 * MARGIN
        addChild(thirdCard)

        val deckSizeText = Text(deck.size().toString(), 20.0)
        addChild(deckSizeText)



        addUpdater {
            val deckSize = deck.size()
            deckSizeText.text = deckSize.toString()
            if( deckSize == 0){
                removeChild(firstCard)
                removeChild(secondCard)
                removeChild(thirdCard)
            }else{
                if( firstCard.parent == null ){
                    addChild(firstCard)
                }
                if( secondCard.parent == null ){
                    addChild(firstCard)
                }
                if( thirdCard.parent == null ){
                    addChild(firstCard)
                }
                deckSizeText.bringToTop()
            }

        }
    }

    private fun createBackCardImage(bitmapRegistry: BitmapRegistry): Image {
        val view = Image(bitmapRegistry.getCardBack())
        view.scale = 1.5
        return view
    }


}