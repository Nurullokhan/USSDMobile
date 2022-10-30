package com.example.ussdmobile

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.ussdmobile.adapters.MainViewPagerAdapter
import com.example.ussdmobile.databinding.ActivityMainBinding
import io.paperdb.Paper


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainViewPagerAdapter
    private lateinit var itemList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Paper.init(this);
        if (Build.VERSION.SDK_INT >= 23 && !check()) {
            this.requestPermissions(arrayOf("android.permission.CALL_PHONE"), 1);
        }

        itemList = ArrayList()
        itemList.add("1")
        itemList.add("2")
        itemList.add("3")
        itemList.add("4")

        adapter = MainViewPagerAdapter(itemList, this)
        binding.viewPager.adapter = adapter

//        setSupportActionBar(binding.appBarMain.toolbar)
//
//        binding.appBarMain.toolbar.setNavigationIcon(R.drawable.ic_menu)
//
//        val drawerLayout: DrawerLayout = binding.layout
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.fragmentContainerView)
//
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                0, 1, 2
//            ), drawerLayout
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragmentContainerView)
//        return navController.navigateUp()
//    }

    private fun check(): Boolean {
        return checkCallingOrSelfPermission("android.permission.CALL_PHONE") == PackageManager.PERMISSION_GRANTED
    }
}