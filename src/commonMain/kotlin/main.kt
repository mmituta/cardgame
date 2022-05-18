import com.soywiz.korge.*
import com.soywiz.korge.animate.playAndWaitEvent
import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korge.view.sprite
import com.soywiz.korim.color.*
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import fight.Enemy
import fight.Fight
import fight.FightController
import fight.Player
import view.*
import view.fight.FightView
import view.fight.effects.SlashEffectView


suspend fun main() = Korge(width = 1920, height = 1080, bgcolor = Colors["#2b2b2b"]) {

    val bitmapRegistry = BitmapRegistry()
    bitmapRegistry.addButton(resourcesVfs["button.png"].readBitmap())
    bitmapRegistry.addEnemy(resourcesVfs["goblin.png"].readBitmap())
    bitmapRegistry.addCard(resourcesVfs["card.png"].readBitmap())
    bitmapRegistry.addPlayer(resourcesVfs["character.png"].readBitmap())
    bitmapRegistry.addBackground(resourcesVfs["background.png"].readBitmap())
    bitmapRegistry.addCardBack(resourcesVfs["card_back.png"].readBitmap())
    bitmapRegistry.addBitmap("hitEffects","hit_effects.png")
    bitmapRegistry.addBitmap("bloodEffects","blood_effects.png")

    val player = Player(10, 3)
    val enemy = Enemy(4, Attack("Slash", 1))
    val robot = Enemy(4, Attack("Slash", 1))

    val deck = RandomDeckFactory().createDeck(20)


    val fight = Fight(player, mutableListOf(enemy, robot), deck)
    val fightView = FightView(fight, views, bitmapRegistry)
    addChild(fightView)


    val controller = FightController(fightView, fight)
    controller.startTurn()

}

