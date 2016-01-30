package com.joseluis.eltenedorlayout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joseluis.eltenedorlayout.R;
import com.joseluis.eltenedorlayout.adapters.ParallaxAdapter;
import com.joseluis.eltenedorlayout.model.Restaurant;
import com.joseluis.eltenedorlayout.views.ParallaxRecycler;
import com.joseluis.eltenedorlayout.views.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 * Fragment que incluye un ParallaxRecycler.
 *
 * Author: José Luis Sánchez
 */
public class DinnerFragment extends Fragment {

    /**
     * Constructor por defecto
     */
    public DinnerFragment(){
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_dinner, container, false);

        //configuramos la vista
        configLayout(rootView);
        return rootView;
    }

    /**
     *  Configura la lista con elementos creados a modo de MOCK o prueba.
     * @param view - root view o vista principal
     */
    private void configLayout(View view){

        //creamos el arraylist con los mocks
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        //creamos los mocks
        Restaurant model1 = new Restaurant();
        model1.setName(getString(R.string.banzai));
        model1.setRating(getString(R.string.banzai_rating));
        model1.setDistance(getString(R.string.distance7));
        model1.setRes(R.mipmap.bg_banzai);
        model1.setPromo(getString(R.string.promo_1));

        Restaurant model2 = new Restaurant();
        model2.setName(getString(R.string.james));
        model2.setRating(getString(R.string.james_rating));
        model2.setRes(R.mipmap.bg_james);
        model2.setDistance(getString(R.string.distance2));
        model2.setPromo(getString(R.string.promo_2));

        Restaurant model3 = new Restaurant();
        model3.setName(getString(R.string.lavaca));
        model3.setRating(getString(R.string.lavaca_rating));
        model3.setRes(R.mipmap.bg_vaca);
        model3.setDistance(getString(R.string.distance3));
        model3.setPromo(getString(R.string.promo_3));

        Restaurant model4 = new Restaurant();
        model4.setName(getString(R.string.newyork));
        model4.setRating(getString(R.string.newyork_rating));
        model4.setRes(R.mipmap.bg_newyork);
        model4.setDistance(getString(R.string.distance4));
        model4.setPromo(getString(R.string.promo_1));

        Restaurant model5 = new Restaurant();
        model5.setName(getString(R.string.sumo));
        model5.setRating(getString(R.string.sumo_rating));
        model5.setRes(R.mipmap.bg_sumo);
        model5.setDistance(getString(R.string.distance4));
        model5.setPromo(getString(R.string.promo_2));



        //añadimos los modelos al array
        restaurants.add(model1);
        restaurants.add(model2);
        restaurants.add(model3);
        restaurants.add(model4);
        restaurants.add(model5);
        restaurants.add(model1);
        restaurants.add(model2);
        restaurants.add(model3);
        restaurants.add(model4);
        restaurants.add(model5);

        //instanciamos la lista
        ParallaxRecycler dinnerRecycler = (ParallaxRecycler) view.findViewById(R.id.dinnerRecycler);
        dinnerRecycler.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        dinnerRecycler.setTypeEffect(ParallaxRecycler.EFFECT_UP);

        //instanciamos el adaptador
        ParallaxAdapter adapter = new ParallaxAdapter(restaurants);

        //set adapter
        dinnerRecycler.setAdapter(adapter);
    }
}
