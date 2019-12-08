package ru.skillbranch.gameofthrones.ui.houses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.skillbranch.gameofthrones.R

class HousesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.houses_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HousesFragment.newInstance())
                .commitNow()
        }
    }

}
