package com.example.gitpum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var homeFragment: HomeFragment
    lateinit var workFragment: WorkFragment
    lateinit var timelineFragment: TimelineFragment
    lateinit var schoolFragment: SchoolFragment
    lateinit var settingFragment: SettingFragment
    lateinit var logoutFragment: LogoutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title="Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle= object :ActionBarDrawerToggle(
            this, drawerLayout , toolbar,
           (R.string.open), (R.string.close)
        ){

        }

        drawerToggle.isDrawerIndicatorEnabled= true //뭔뜻이니
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        //now implement navigation item selected listener
        //The default fragment is homeFragment
        homeFragment= HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
            // so this is our fragment code


    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
    //now create related fragment

        when(menuItem.itemId){
            R.id.home->{
                homeFragment= HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.Frame_layout, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()}
            // so this is our fragment code
            R.id.work->{
                workFragment= WorkFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.Frame_layout, workFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.school->{
                schoolFragment= SchoolFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.Frame_layout, schoolFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.timeline->{
                timelineFragment= TimelineFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.Frame_layout, timelineFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.setting->{
                settingFragment= SettingFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.Frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}
            R.id.logout->{
                logoutFragment= LogoutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.Frame_layout, logoutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()}

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
        super.onBackPressed()}
    }
}
