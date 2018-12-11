package com.dicoding.dailyfootball

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ItemUI : AnkoComponent<ViewGroup> {

    companion object {
        const val tvName = 1
        const val ivImage = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {

        linearLayout {
            this.orientation = LinearLayout.HORIZONTAL
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView {
                id = ivImage
            }.lparams {
                height = dip(40)
                width = dip(40)
                gravity = Gravity.CENTER
            }

            textView {
                id = tvName
                textSize = 16f
            }.lparams {
                gravity = Gravity.CENTER
                margin = dip(10)
            }
        }
    }
}