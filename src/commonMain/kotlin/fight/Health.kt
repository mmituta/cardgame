package fight

import kotlin.math.max
import kotlin.math.roundToInt

class Health(val initialHp: Int) {
    var currentHp = initialHp

    fun hitFor(dmg: Int){
        currentHp = max(0, currentHp - dmg)
    }

    fun hitForPercentage(percentage: Double){
        currentHp = max(0, currentHp - (percentage * currentHp).roundToInt())
    }

    fun isEmpty(): Boolean {
        return  currentHp == 0
    }

    fun isFull(): Boolean{
        return currentHp == initialHp
    }
}