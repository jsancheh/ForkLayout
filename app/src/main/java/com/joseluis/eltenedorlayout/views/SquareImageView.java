package com.joseluis.eltenedorlayout.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * Clase que extiende de Imageview creada para implementar una imagen cuadrada ANCHO x ANCHO. Esta
 * vista se usa para que el efecto creado al realizar el scroll en la lista no deje espacios vacios o
 * en blanco entre Rows.
 *
 * Author: José Luis Sánchez
 */
public class SquareImageView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener {

    private int size;

    /**
     *
     */
    private static final int TAG = 0;

    /**
     * Constructor por defecto
     * @param context - contexto de la aplicación
     */
    public SquareImageView(Context context) {
        super(context);
        setTag(TAG);
    }

    /**
     * Constructor por defecto
     * @param context - contexto de la app
     * @param attrs - atributos
     */
    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTag(TAG);
    }

    /**
     * Constructor por defecto
     * @param context - contexto de la app
     * @param attrs - atributos
     * @param defStyleAttr - estilos
     */
    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTag(TAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //seteamos el ancho y el ancho para generar la imagen cuadrada
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void onGlobalLayout() {
        setSize(getWidth());
    }

    private void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

}
