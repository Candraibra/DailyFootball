package com.dicoding.dailyfootball

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class Deskripsi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val club: Club = intent.getParcelableExtra("clubBundle")

        verticalLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)
            textView {
                textSize = 16f
                text = club.name
            }.lparams {
                gravity = Gravity.CENTER
                setMargins(0, dip(5), 0, dip(10))
            }
            imageView {
                Glide.with(this@Deskripsi).load(club.image).into(this)
            }.lparams {
                height = dip(60)
                width = dip(60)
                gravity = Gravity.CENTER
            }

            textView {
                textSize = 16f
                text = club.desc
            }.lparams {
                gravity = Gravity.CENTER
            }
        }
    }
}

