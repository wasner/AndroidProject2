package com.example.mael.androidproject2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mael.androidproject2.liste.ItemListeFrigo;
import com.example.mael.androidproject2.reseau.ItemReseau;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    Fragment [] Frags = new Fragment[3] ;
    BalladesFragsPagerAdapter balladesFragsPagerAdapter;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Frags[0] = ItemReseau.newInstance(1);
        Frags[1] = ItemListeFrigo.newInstance(1);
        Frags[2] = ItemListeFrigo.newInstance(1);
        balladesFragsPagerAdapter = new BalladesFragsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(balladesFragsPagerAdapter);
    }

    @Override
    public void onFragmentInteraction(String msg) {

    }
    public class BalladesFragsPagerAdapter extends FragmentStatePagerAdapter {
        public BalladesFragsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int i) {
            return Frags[i];}
        @Override
        public int getCount() {
            return Frags.length ;}
        @Override
        public CharSequence getPageTitle(int position){
            return "OBJECT " + (position + 1);}
    }
}
