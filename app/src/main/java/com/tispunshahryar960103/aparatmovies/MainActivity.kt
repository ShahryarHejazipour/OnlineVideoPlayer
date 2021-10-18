package com.tispunshahryar960103.aparatmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.tispunshahryar960103.aparatmovies.databinding.ActivityMainBinding
import com.tispunshahryar960103.aparatmovies.orm.AppDatabase
import com.tispunshahryar960103.aparatmovies.orm.VideoDAO
import com.tispunshahryar960103.aparatmovies.utils.AppConfig
import com.tispunshahryar960103.aparatmovies.utils.Constants

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    SearchView.OnQueryTextListener, NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    var toggle: ActionBarDrawerToggle? = null
    lateinit var appConfig: AppConfig

    lateinit var videoDAO: VideoDAO

    companion object {
        init {
            System.loadLibrary(Constants.LOAD_LIBRARY.str);
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        appConfig = AppConfig(applicationContext)

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

        val str: String = stringFromJNI()
        Toast.makeText(applicationContext, str, Toast.LENGTH_SHORT).show()

        binding.navigationView.setNavigationItemSelectedListener(this)


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

            R.id.item_login -> {

                val userId = appConfig.getLoginCode()
                if (userId > 0) {
                   // navigateToAFragment(R.id.categoryFragment)
                    Toast.makeText(applicationContext, "شما پیش از این وارد شده بوده اید", Toast.LENGTH_SHORT).show()
                } else {
                    navigateToAFragment(R.id.loginFragment)
                }

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

        //آیتم مورد نظر را گرفته و در searchItem می ریزیم
        val searchItem: MenuItem? = menu?.findItem(R.id.item_search)

        //آیتم بالا را به ویجت SearchView تبدیل یا cast می کنیم که با کلیک روی آن حالت یک باکس سرچ برای تایپ عبارت سرچ را به خود بگیرد
        val searchView: SearchView = searchItem?.actionView as SearchView

        //queryHint برای نسان دادن یک hint درون باکس سرچ است
        searchView.queryHint = "Search View"

        //ست کردن Listener برای دریافت عبارت سرچ شده توسط کاربر یا همان query و مدیریت آن
        searchView.setOnQueryTextListener(this)



        return super.onCreateOptionsMenu(menu)
    }


    override fun onQueryTextSubmit(query: String?): Boolean {

        val bundle = Bundle()
        bundle.putString("search", query)
        navController.navigate(R.id.searchFragment, bundle)

        return false


    }

    override fun onQueryTextChange(newText: String?): Boolean {

        return true

    }


    //for clicking the Option menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return super.onOptionsItemSelected(item)
    }


    //Using NDK C++
    private external fun stringFromJNI(): String


}




