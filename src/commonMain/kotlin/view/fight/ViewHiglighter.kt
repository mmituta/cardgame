package view.fight

import com.soywiz.korge.view.View
import com.soywiz.korge.view.filter.IdentityFilter
import com.soywiz.korge.view.filter.SwizzleColorsFilter

class ViewHiglighter(private val view: View) {

    fun select(){
        view.filter = SwizzleColorsFilter("bgra")
    }

    fun unselect(){
        view.filter = IdentityFilter
    }
}