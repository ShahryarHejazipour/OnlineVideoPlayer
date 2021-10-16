package com.tispunshahryar960103.aparatmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import com.tispunshahryar960103.aparatmovies.databinding.ActivityMainBinding
import com.tispunshahryar960103.aparatmovies.utils.Constants

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    var toggle: ActionBarDrawerToggle? = null

    companion object{
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str);
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)



        binding.bottomMenu.setOnItemSelectedListener(this)


        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, navController)
/*
        val fragmentList=ArrayList<Fragment>()
        val homeFragment=HomeFragment()
        val categoryFragment=CategoryFragment()
        val favoriteFragment=FavoriteFragment()
        fragmentList.add(homeFragment)
        fragmentList.add(categoryFragment)
        fragmentList.add(favoriteFragment)

        binding.screenPager.adapter=HomeAdapter(supportFragmentManager,lifecycle,fragmentList)*/


        //Attaching Toggle for Navigation View

        if (toggle == null) {

            toggle = ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.open,
                R.string.close
            )
            toggle!!.isDrawerSlideAnimationEnabled = true
            toggle!!.isDrawerIndicatorEnabled = true
            toggle!!.syncState()


        }

        val str:String=stringFromJNI()
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.item_home -> {

                navigateToAFragment(R.id.homeFragment)
                // checkSelectedItem(0)


            }
            R.id.item_category -> {

                navigateToAFragment(R.id.categoryFragment)
                //checkSelectedItem(1)
            }
            R.id.item_favorite -> {

                navigateToAFragment(R.id.favoriteFragment)
                // checkSelectedItem(2)
            }
        }

        return true

    }


    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }

    private fun navigateToAFragment(itemId: Int) {
        navController.navigate(itemId)
    }

    private fun checkSelectedItem(index: Int) {
        binding.bottomMenu.menu.getItem(index).isChecked = true
    }


    //for implementing the search menu with Option Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }


    //for clicking the Option menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return super.onOptionsItemSelected(item)
    }


    //Using NDK C++
   private external fun stringFromJNI(): String




}




