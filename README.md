# Developed By

José Luis Sánchez

# ForkLayout

Parallax layout que recrea el mismo efecto que la aplicación de "El Tenedor", "TheFork" o "LaFourchette". Se compone de una lista de elementos (RecyclerView) con imágenes, las cuales con el desplzamiento del Scroll crean un efecto parallax. 

Hay dos tipos de efectos, uno en el que la imagen se desplaza al contrario que la dirección del scroll y otro en el que la imagen se desplaza en la misma dirección pero con una velocidad menor provocando un efecto. 

Para usar la lista solo teneis que usar las clases ParallaxRecycler.java, SquareImageView.java, ParallaxAdapter.java y el recurso lay_parallax_row.xml. El resto de elementos son añadidos para configurar el ejemplo.

![alt tag](https://github.com/jsancheh/ForkLayout/blob/master/captura.png)

# Uso
ParallaxRecycler.java
<code><pre>
ParallaxRecycler recycler = (ParallaxRecycler) view.findViewById(R.id.recycler);
recycler.setAdapter(adapter);
</code></pre>

lay_parallax_row.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="@dimen/rowHeight">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="@dimen/rowHeight">

        <!-- IMAGEN CUADRADA -->
        <com.joseluis.eltenedorlayout.views.SquareImageView
            android:layout_centerInParent="true"
            android:src="@mipmap/bg_banzai"
            android:id="@+id/imgParallax"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scaleType="centerCrop"/>

    </RelativeLayout>
</LinearLayout>
```
