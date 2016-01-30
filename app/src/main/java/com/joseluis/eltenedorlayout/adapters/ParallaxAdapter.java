package com.joseluis.eltenedorlayout.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joseluis.eltenedorlayout.R;
import com.joseluis.eltenedorlayout.model.Restaurant;
import com.joseluis.eltenedorlayout.views.SquareImageView;

import java.util.List;

/**
 * RecyclerView.Adapter Class
 *
 * Author: José Luis Sánchez
 */
public class ParallaxAdapter extends RecyclerView.Adapter<ParallaxAdapter.ViewHolder> {

    /**
     * Constante que inicializa el valor del scroll de la imagen
     */
    private static final int SCROLL = 0;

    /**
     * Lista de objetos modelo
     */
    private List<Restaurant> restaurants;

    /**
     * Constructor del Adaptador
     * @param restaurants - restaurantes
     */
    public ParallaxAdapter(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public ParallaxAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lay_parallax_row, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        //obtenemos el modelo con la posicion
        Restaurant model = this.restaurants.get(position);

        //seteamos los datos en las vistas incluidas en el ViewHolder pasado por parametro
        viewHolder.tvName.setText(model.getName());
        viewHolder.imgParallax.setImageResource(model.getRes());
        viewHolder.imgParallax.setTag(SCROLL);
        viewHolder.tvRating.setText(model.getRating());
        viewHolder.tvDistance.setText(model.getDistance());
        viewHolder.tvPromotion.setText(model.getPromo());

        //guardamos el hilder en el tag
        viewHolder.itemView.setTag(viewHolder);
    }

    /**
     * Clase tipo ViewHolder que contiene cada Row (Views) de la lista
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Vista tipo texto
         */
        public TextView tvName;

        /**
         * Vista tipo texto
         */
        public TextView tvRating;

        /**
         * Vista tipo texto
         */
        public TextView tvDistance;

        /**
         * Vista tipo texto
         */
        public TextView tvPromotion;

        /**
         * Vista tipo SquareImageView (ImageView)
         */
        public SquareImageView imgParallax;

        /**
         * Constructor
         * @param view - view o layout desde el que vamos a inflar las vistas
         */
        public ViewHolder(View view) {

            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            imgParallax = (SquareImageView) view.findViewById(R.id.imgParallax);
            tvRating = (TextView) view.findViewById(R.id.tvRating);
            tvDistance = (TextView) view.findViewById(R.id.tvDistance);
            tvPromotion = (TextView) view.findViewById(R.id.tvPromotion);

        }
    }


    @Override
    public int getItemCount() {
        return this.restaurants.size();
    }
}
