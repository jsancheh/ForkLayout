package com.joseluis.eltenedorlayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.joseluis.eltenedorlayout.adapters.PagerAdapter;

/**
 * Actividad Principal.
 *
 * Author: José Luis Sánchez
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciamos el viewpager
        ViewPager vpRestaurants = (ViewPager) findViewById(R.id.vpRestaurants);

        //instanciamos el adaptador de fragment
        PagerAdapter vpAdapter = new PagerAdapter(getSupportFragmentManager());
        vpRestaurants.setAdapter(vpAdapter);

        //instanciamos y configuramos el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //instanciamos y configuramos las tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vpRestaurants);
    }

}
