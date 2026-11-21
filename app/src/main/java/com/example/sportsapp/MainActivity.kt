package com.example.sportsapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val topLevel = setOf(
            R.id.homeFragment, R.id.accountFragment,
            R.id.profileFragment, R.id.mySportsFragment
        )
        appBarConfiguration = AppBarConfiguration(topLevel)
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNav.setupWithNavController(navController)

        // Badge sa My Sports tab
        bottomNav.getOrCreateBadge(R.id.mySportsFragment).number = 3

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Gitago ang bottom bar sa secondary (sport) screens
            bottomNav.visibility =
                if (destination.id in topLevel) View.VISIBLE else View.GONE
            // Mawala ang badge kung ablihan ang My Sports
            if (destination.id == R.id.mySportsFragment) {
                bottomNav.removeBadge(R.id.mySportsFragment)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHost = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHost.navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}