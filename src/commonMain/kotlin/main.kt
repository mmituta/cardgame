import com.soywiz.korge.*
import com.soywiz.korim.color.*
import view.*


suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {

    val player = Player(10, 3)
    val enemy = Enemy(4, 5)
    val deck = RandomDeckFactory().createDeck(20)


    val fight = Fight(player, enemy, deck)
    val fightView = FightView(fight, views)
    addChild(fightView)

    val controller = FightController(fightView, fight)
    controller.startTurn()


}

