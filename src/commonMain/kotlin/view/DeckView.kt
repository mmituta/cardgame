package view

import Deck
import com.soywiz.korge.view.*


class DeckView(deck: Deck) : Container() {

    init {
        val deckSizeText = Text(deck.size().toString())
        addChild(deckSizeText)

        addUpdater {
            deckSizeText.text = deck.size().toString()
        }
    }


}