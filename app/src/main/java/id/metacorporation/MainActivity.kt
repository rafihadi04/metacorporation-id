package id.metacorporation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import id.metacorporation.fragment.*
import id.metacorporation.repository.DataRepository

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav :ChipNavigationBar
    /*lateinit var viewPager : ViewPager2*/

    //var currentPos :Int? = null
    val dataRepository : DataRepository = DataRepository()
    //lateinit var notificationBuilder :NotificationCompat.Builder

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*currentPos = savedInstanceState?.getInt("SelectedPosisiton") ?: R.id.home_Fragment*/

        /*viewPager = findViewById(R.id.viewPager)
        viewPagerInit()*/

        createNotificationChannel()
        bottomNav = findViewById(R.id.bottomNav)
        bottomNavInit()


    }

    /*private fun viewPagerInit() {

        val homeFragment = HomeFragment(dataRepository)
        val tvFragment = TvFragment(dataRepository)
        val newsFragment = NewsFragment()
        val radioFragment = RadioFragment(dataRepository)
        val aboutFragment = AboutFragment()

        val vpAdapter = ViewPagerAdapter(this)
        vpAdapter.addFragment(homeFragment,R.id.home_Fragment)
        vpAdapter.addFragment(tvFragment, R.id.tv_Fragment)
        vpAdapter.addFragment(newsFragment, R.id.news_Fragment)
        vpAdapter.addFragment(radioFragment, R.id.radio_Fragment)
        vpAdapter.addFragment(aboutFragment, R.id.about_Fragment)


        viewPager.adapter = vpAdapter
        viewPager.reduceDragSensitivity()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNav.setItemSelected(vpAdapter.menulistId[position],false)
            }
        })

        viewPager.isUserInputEnabled = false

    }*/

    /*fun ViewPager2.reduceDragSensitivity() {
        val recyclerViewField = ViewPager2::class.java.getDeclaredField("mRecyclerView")
        recyclerViewField.isAccessible = true
        val recyclerView = recyclerViewField.get(this) as RecyclerView

        val touchSlopField = RecyclerView::class.java.getDeclaredField("mTouchSlop")
        touchSlopField.isAccessible = true
        val touchSlop = touchSlopField.get(recyclerView) as Int
        touchSlopField.set(recyclerView, touchSlop*8)       // "8" was obtained experimentally
    }*/

    fun bottomNavInit(){

        val homeFragment = HomeFragment(dataRepository)
        val tvFragment = TvFragment(dataRepository)
        val newsFragment = NewsFragment()
        val radioFragment = RadioFragment(dataRepository)
        val aboutFragment = AboutFragment()

        /*supportFragmentManager.beginTransaction().also {
            it.add(homeFragment,"homeFragment")
            it.add(tvFragment,"TvFragment")
            it.add(newsFragment,"NewsFragment")
            it.add(radioFragment,"radioFragment")
            it.add(aboutFragment,"aboutFragment")
            it.commit()
        }*/


        bottomNav.setOnItemSelectedListener {
            when(it){
                R.id.home_Fragment -> setCurrentFragment(homeFragment) /*viewPager.currentItem = 0*/
                R.id.tv_Fragment -> setCurrentFragment(tvFragment)/* viewPager.currentItem = 1*/
                R.id.news_Fragment -> setCurrentFragment(newsFragment) /*viewPager.currentItem = 2*/
                R.id.radio_Fragment -> setCurrentFragment(radioFragment) /*viewPager.currentItem = 3*/
                R.id.about_Fragment -> setCurrentFragment(aboutFragment) /*viewPager.currentItem = 4*/
            }
        }

        //setCurrentFragment(homeFragment)
        bottomNav.setItemSelected(R.id.home_Fragment)


    }

    private fun setCurrentFragment(fragment: Fragment){

        val listFragment = supportFragmentManager.fragments
        if(listFragment.isNotEmpty()){
            for(_fragment in listFragment){
                Log.d("hideFragment",_fragment.javaClass.name.toString())
                supportFragmentManager.beginTransaction()
                    .setMaxLifecycle(_fragment,Lifecycle.State.STARTED)
                    .hide(_fragment)
                    .commit()
                /*if(!_fragment.isDetached){
                }*/
            }
        }
        if(!fragment.isAdded){
            Log.d("addFragment",fragment.javaClass.name.toString())
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment,fragment,fragment.javaClass.name.toString())
                commit()
            }
        }else{
            Log.d("showFragment",fragment.javaClass.name.toString())
            supportFragmentManager.beginTransaction()
                .setMaxLifecycle(fragment,Lifecycle.State.RESUMED)
                .show(fragment)
                .commit()
        /*replace(R.id.fragment, fragment).commit()*/
        }


    }


    override fun onBackPressed() {

        if (doubleBackToExitPressedOnce or onBackPressedDispatcher.hasEnabledCallbacks()) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, getString(R.string.toast_double_back), Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // Create the NotificationChannel
            val name = "Program"
            val descriptionText = "Menampilan notifikasi program"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel("Program", name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }


}