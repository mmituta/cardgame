import com.soywiz.korge.*
import com.soywiz.korim.color.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import view.*


suspend fun main() = Korge(width = 1920, height = 1080, bgcolor = Colors["#2b2b2b"]) {

    val player = Player(10, 3)
    val enemy = Enemy(4, 5, resourcesVfs["goblin.png"].readBitmap())
    val robot = Enemy(4, 5, resourcesVfs["goblin.png"].readBitmap())
    val cardBitmap = resourcesVfs["card.png"].readBitmap()
    val deck = RandomDeckFactory().createDeck(20)


    val fight = Fight(player, mutableListOf(enemy, robot), deck)
    val fightView = FightView(fight, views, cardBitmap)
    addChild(fightView)

    val controller = FightController(fightView, fight)
    controller.startTurn()


}

