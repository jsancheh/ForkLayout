package com.joseluis.eltenedorlayout.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.joseluis.eltenedorlayout.adapters.ParallaxAdapter;

/**
 * RecyclerView Class que recrea el mismo estilo que las listas que aparecen en la aplicación del Tenedor.
 *
 * Author: José Luis Sánchez
 */
public class ParallaxRecycler extends RecyclerView {

    /**
     * Velocidad del efecto
     */
    private float scrollSpeed = .3f;

    /**
     * Constante para poder calcular el maximo disponible para realizar el desplazamiento de la
     * imagen.
     */
    private static final int MIDDLE = 2;

    /**
     * Constante para identificar el tipo de efecto
     */
    public static final int EFFECT_DOWN = 1;

    /**
     *  Constante para identificar el tipo de efecto
     */
    public static final int EFFECT_UP = 2;

    /**
     *
     */
    private int typeEffect = EFFECT_DOWN;



    /**
     * Constrcutor por defecto
     * @param context - contexto de la aplicación
     */
    public ParallaxRecycler(Context context) {
        super(context);
        initScrollListener();
        configLayout(context);
    }

    /**
     * Constrcutor por defecto
     * @param context - contexto de la aplicación
     * @param attrs - atributos
     */
    public ParallaxRecycler(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScrollListener();
        configLayout(context);
    }

    /**
     * Constrcutor por defecto
     * @param context - contexto de la aplicación
     * @param attrs - atributos
     * @param defStyle - estilos
     */
    public ParallaxRecycler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollListener();
        configLayout(context);
    }

    /**
     *  Inicializa el listener del scroll
     */
    private void initScrollListener(){
        addOnScrollListener(parallaxScrollListener);
    }

    /**
     *  Listener que controlla el scroll en la lista
     */
    private OnScrollListener parallaxScrollListener = new OnScrollListener() {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            //usamos solamente la vista y el valor vertical (Y)
            configureEffect(recyclerView, dy);
        }
    };


    /**
     *  Método que configura el efecto Parallax de los elementos que están visibles mientras hacemos
     *  scroll.
     *
     * @param recyclerView - Lista
     * @param dy - cantidad de desplazamiento al hacer scroll
     */
    private void configureEffect(RecyclerView recyclerView, int dy){

        //implementa una funcionalidad similiar a lo que sería la clase ListView
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        View row = layoutManager.getChildAt(0);
        int maxHeight = row.getHeight();

        //obtenemos el indice de la primera vista visible
        int firstVisible = layoutManager.findFirstVisibleItemPosition();

        //obtenemos el total de elementos visibles
        int visibleCount = Math.abs(firstVisible - layoutManager.findLastVisibleItemPosition());

        //recorremos los elementos (SquareImageView) desde el primer indice visible hasta el total de visibles
        //y con setScrollY generamos el efecto Parallax
        for (int i = firstVisible; i < (firstVisible + visibleCount); i++) {

            //obtenemos la imagen
            SquareImageView imgRestaurant = ((ParallaxAdapter.ViewHolder) recyclerView.getLayoutManager().findViewByPosition(i).getTag()).imgParallax;
            int imgHeight = imgRestaurant.getHeight();
            int translationHeight = (Math.abs(imgHeight - maxHeight) / MIDDLE);

            if(getTypeEffect() == EFFECT_DOWN){

                //efecto
                parallaxEffectUp(imgRestaurant, dy, translationHeight);
            } else {

                //efecto
                parallaxEffectDown(imgRestaurant, dy, translationHeight);
            }
        }
    }

    /**
     *  Metodo que genera un efecto parallax que hace que la imagen se desplace hacia la misma direccion del scroll pero a distinta velocidad
     *  provocando un efecto parallax
     *
     * @param imgRestaurant - imagen que vamos a desplazar
     * @param dy - cantidad de movimiento
     * @param translationHeight - maximo valor que tenemos disponible para mover hacia arriba/abajo
     */
    private void parallaxEffectDown(SquareImageView imgRestaurant, int dy, int translationHeight){

        //obtenemos el ultimo valor almacenado en el tag de la imagen (scroll)
        int scrollY = (int)imgRestaurant.getTag();

        //si es down
        if(dy > 0){

            //aumentamos para crear efecto
            scrollY++;

            //si el valor del scroll multiplado por la velocidad no es superior al maximo disponible
            if(Math.abs(scrollY*getScrollSpeed()) < translationHeight){

                //guardamos el valor en el tag
                imgRestaurant.setTag(scrollY);

                //desplazamos la imagen
                imgRestaurant.setScrollY((int) (scrollY * getScrollSpeed()));
            }
        } else if(dy < 0) {

            //si vamos hacia el lado contrario restamos
            scrollY--;

            //si cumple con el maximo disponible
            if(Math.abs(scrollY*getScrollSpeed()) < translationHeight){

                //guardamos el valor
                imgRestaurant.setTag(scrollY);

                //desplazamos para el efecto
                imgRestaurant.setScrollY((int) (scrollY * getScrollSpeed()));
            }
        }
    }

    /**
     * Metodo que genera un efecto parallax que hace que la imagen se desplace hacia la dirección contraria del scroll a distinta velocidad
     * provocando un efecto parallax.
     *
     * @param imgRestaurant - imagen que vamos a desplazar
     * @param dy - cantidad de movimiento
     * @param translationHeight - maximo valor que tenemos disponible para mover hacia arriba/abajo
     */
    private void parallaxEffectUp(SquareImageView imgRestaurant, int dy, int translationHeight){

        //obtenemos el ultimo valor almacenado en el tag de la imagen (scroll)
        int scrollY = (int)imgRestaurant.getTag();

        //si es down
        if(dy > 0){

            //restamos para crear efecto
            scrollY--;

            //si el valor del scroll multiplado por la velocidad no es superior al maximo disponible
            if(Math.abs(scrollY*getScrollSpeed()) < translationHeight){

                //guardamos el valor en el tag
                imgRestaurant.setTag(scrollY);

                //desplazamos la imagen
                imgRestaurant.setScrollY((int) (scrollY * getScrollSpeed()));
            }
        } else if(dy < 0) {

            //si vamos hacia el lado contrario aumentamos
            scrollY++;

            //si cumple con el maximo disponible
            if(Math.abs(scrollY*getScrollSpeed()) < translationHeight){

                //guardamos el valor
                imgRestaurant.setTag(scrollY);

                //desplazamos para el efecto
                imgRestaurant.setScrollY((int) (scrollY * getScrollSpeed()));
            }
        }
    }

    /**
     * Adjunta la lista al layout manager
     * @param context - conexto de la aplicación
     */
    private void configLayout(Context context){

        //instanciamos el layoutmanager
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(llm);
    }

    /**
     *  Setter para la velocidad del efecto, el valor debe ser entre 0.01 - 0.99.
     * @param speed - velocidad del efecto
     */
    public void setScrollSpeed(float speed) {
        this.scrollSpeed = speed;
    }

    /**
     *  Getter con la velocidad del efecto
     * @return - float
     */
    private float getScrollSpeed(){
        return this.scrollSpeed;
    }

    /**
     * Devuelve el tipo de efecto
     * @return valor del efecto.
     */
    public int getTypeEffect(){
        return typeEffect;
    }

    /**
     * Setea el valor del efecto a configurar
     * @param type - tipo de efecto
     */
    public void setTypeEffect(int type){
        this.typeEffect = type;
    }
}
