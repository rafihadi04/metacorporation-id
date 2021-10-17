package id.metacorporation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.metacorporation.MainActivity

class ViewPagerAdapter(val activity: MainActivity) : FragmentStateAdapter(activity) {

    private val menulist = arrayListOf<Fragment>()
    val menulistId = arrayListOf<Int>()

    override fun getItemCount(): Int {
        return menulist.size
    }

    override fun createFragment(position: Int): Fragment {
        return menulist[position]
    }

    fun addFragment(fragment: Fragment, idBottomNav: Int){
        menulist.add(fragment)
        menulistId.add(idBottomNav)

    }

}