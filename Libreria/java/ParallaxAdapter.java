package com.joseluis.eltenedorlayout.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joseluis.eltenedorlayout.R;
import com.joseluis.eltenedorlayout.views.SquareImageView;

import java.lang.Object;
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
    private List<?> items;

    /**
     * Constructor del Adaptador
     * @param items - lista de elementos
     */
    public ParallaxAdapter(List<?> items) {
        this.items = items;
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

        //seteamos los datos en las vistas incluidas en el ViewHolder pasado por parametro
        viewHolder.imgParallax.setTag(SCROLL);

        //guardamos el hilder en el tag
        viewHolder.itemView.setTag(viewHolder);
    }

    /**
     * Clase tipo ViewHolder que contiene cada Row (Views) de la lista
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

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
            imgParallax = (SquareImageView) view.findViewById(R.id.imgParallax);
        }
    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
