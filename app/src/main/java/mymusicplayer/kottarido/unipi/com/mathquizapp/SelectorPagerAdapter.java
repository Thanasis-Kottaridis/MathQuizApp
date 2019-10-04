package mymusicplayer.kottarido.unipi.com.mathquizapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SelectorPagerAdapter extends FragmentPagerAdapter {

    //periexei ta fragments
    private final List<Fragment> mFragmentList = new ArrayList<>();
    //periexei tous titlous
    private final List<String> mFragmentTitleList = new ArrayList<>();

    // default constructor
    public SelectorPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //prosthetei ta fragments stin fragmentList
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    //epistrefei ton titlo tou fragment
    public List<String> getmFragmentTitleList() {
        return mFragmentTitleList;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
