package com.joseluis.eltenedorlayout.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.joseluis.eltenedorlayout.fragments.BestFragment;
import com.joseluis.eltenedorlayout.fragments.DinnerFragment;

/**
 * Sencillo adaptador de fragments.
 *
 * Author: José Luis Sánchez
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    /**
     * Identificador para el fragment de mejores restaurantes
     */
    private static final int BEST_RESTAURANT = 0;

    /**
     *  Identificador para el fragment de restaurantes para cenas
     */
    private static final int DINNER_RESTAURANT = 1;

    /**
     * Número de paginas
     */
    private static final int NUM_PAGES = 2;

    /**
     * Titulo del fragment BEST_RESTAURANT
     */
    private static final String BEST = "VALORADOS";

    /**
     *Titulo del fragment DINNER_RESTAURANT
     */
    private static final String DINNER = "PARA CENAR";

    /**
     * Array de strings que contiene los titulos de los fragments
     */
    private final String[] titles = {BEST, DINNER};

    /**
     *  Constructor por defecto
     * @param fm - FragmentManager
     */
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case BEST_RESTAURANT:
                return new BestFragment();

            case DINNER_RESTAURANT:
                return new DinnerFragment();

            default:
                return new BestFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
