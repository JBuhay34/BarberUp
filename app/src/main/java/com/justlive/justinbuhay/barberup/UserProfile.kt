package com.justlive.justinbuhay.barberup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

class UserProfile : FragmentActivity() {

    private var mProfileFragmentPagerAdapter: ProfileFragmentPagerAdapter? = null
    private var mViewPager: ViewPager? = null
    private var mTabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        mTabLayout = findViewById(R.id.tablayout)
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText("BarberInformation"))
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText("Availability"))

        mProfileFragmentPagerAdapter = ProfileFragmentPagerAdapter(supportFragmentManager)
        mViewPager = findViewById(R.id.pager)


        mViewPager!!.setAdapter(mProfileFragmentPagerAdapter)
        mTabLayout!!.setupWithViewPager(mViewPager)
    }

    class ProfileFragmentPagerAdapter: FragmentPagerAdapter{

        constructor(fm: FragmentManager) : super(fm)


        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            when(position){
                0-> return BarberProfileFragment()
                1-> return BarberAvailabilityFragment()

                else ->
                        return BarberProfileFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0-> return "Barber Information"
                1-> return "Availability"

                else ->
                    return "Barber Information"
            }
        }


    }
}
