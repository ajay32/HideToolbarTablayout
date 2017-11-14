package com.example.macmine.hidetoolbartablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);  // there are two layout file ...in activity main we put the Tablayout and viewpager in "collapsing toolbar Layout".inside cordinator layout.so that it will scroll up..
     //  setContentView(R.layout.activity_main2);  // to make Toolbar , Viewpage and TabLayout ...all of three to scroll up ..so i put all of them in Cordinator layout ..

        findViews();
        setSupportActionBar(toolbar);

        //create and set ViewPager adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //create tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Data 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Data 2"));

        //attach tab layout with ViewPager
        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //change selected tab when viewpager changed page
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //change viewpager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //===adapter

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           // return new BlankFragment(); // if you want use just single fragment for all the tabs otherwise

            switch (position) {
                case 0:
                    BlankFragment tab1 = new BlankFragment();
                    return tab1;
                case 1:
                    BlankFragment2 tab2 = new BlankFragment2();
                    return tab2;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}