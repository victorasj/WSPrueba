package com.victorasj.wsprueba

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

private val TAB_TITLES = arrayOf(
    R.string.popular_tab,
    R.string.favourite_tab
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, private val fragmentList : List<Fragment>) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) : Fragment {
        return when(position){
            0 -> fragmentList[0]
            1 -> fragmentList[1]
            else -> fragmentList[0]
        }
    }

    override fun getPageTitle(position: Int) : CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}