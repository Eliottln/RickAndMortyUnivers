package com.example.rickandmortyunivers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortyunivers.R
import com.example.rickandmortyunivers.ui.ui.characterslist.CharactersListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharactersListFragment.newInstance())
                .commitNow()
        }
    }
}