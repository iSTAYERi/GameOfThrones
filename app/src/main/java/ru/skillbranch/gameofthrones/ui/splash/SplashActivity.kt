package ru.skillbranch.gameofthrones.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.skillbranch.gameofthrones.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SplashFragment.newInstance())
                .commitNow()
        }
    }

}
