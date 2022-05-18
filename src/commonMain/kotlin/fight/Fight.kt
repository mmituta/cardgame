package fight

import cards.Card
import Deck

class Fight(val player: Player, val enemies: MutableList<Enemy>, val deck: Deck) : EnemyDiedListener {
    var hand = Hand()
    var turn = 0
    private val deadEnemies = mutableListOf<Enemy>()
    val discardedPile = DiscardedPile()
    var ap = 0
    var enemySelector: EnemyProvider? = null
    init {
        ap = player.ap
        enemies.forEach { enemy -> enemy.addListener(this) }
    }


    fun drawHand(number: Int): Hand {
        hand = deck.drawHand(number)
        return hand
    }

    fun playCard(card: Card) {
        if (card.play(this)) {
            hand.removeCard(card)
            ap -= card.cost
            discardedPile.addCard(card)
        }
    }

    fun startTurn() {
        turn += 1
        ap = player.ap
    }

    override fun onEnemyDied(enemy: Enemy) {
        enemies.remove(enemy)
        deadEnemies.add(enemy)
    }

    fun selectEnemy(): Enemy? {
        if( enemies.size == 1){
            return enemies[0]
        }

        if(enemySelector != null) {
            return enemySelector?.selectEnemy()
        }
        return null
    }


}