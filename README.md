# TenedorScrollEffect
Clase y proyecto de ejemplo para Android que realiza el mismo efecto que la aplicación de "El Tenedor", "TheFork" o "LaFourchette" para iOS (Apple). 

Para implementar el efecto Parallax de cada una de las Imagenes que componen la lista he implementado una Clase que extiende de ImageView con la salvedad que la Imagen tiene el mismo alto que ancho, es decir, es una imagen cuadrada. Con esto evitamos que al hacer scroll y en consecuencia realizar el efecto la lista no deje espacios entre Imágenes.

Para mostrar el funcionamiento he construido una aplicación en la que utilizo las clases mencionadas debajo y simulo una app sobre restaurantes.

La clase que implementa la lista y el efecto es ParallaxRecycler.java y para instanciarla sólo es necesario
<code><pre>
  ParallaxRecycler pRecycler = (ParallaxRecycler) findViewById(R.id.pRecycler);
</pre></code>

El adaptador creado para usar la Lista es RestaurantAdapter.java
<code><pre>
  RestaurantAdapter adapter = new RestaurantAdapter(List<Model> elementos);
</pre></code>

El layout donde queramos incluir la lista debe contener
```xml
  <com.joseluis.eltenedorlayout.views.ParallaxRecycler
        android:id="@+id/pRecycler"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
El layout o Row lay_parallax_row.xml, la distribución es opcional, al igual que los elementos. Si se cambian se debe reflejar también en la clase que infla estas vistas RestaurantAdapter.java
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
            android:id="@+id/imgParallax"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scaleType="centerCrop"/>


        <!-- SOMBRA -->

        <LinearLayout
            android:background="@color/colorBgSquareImage"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </LinearLayout>

        <!-- NOMBRE -->

        <TextView
            android:id="@+id/tvName"
            android:text="@string/app_name"
            android:textSize="@dimen/textSizeSmallMedium"
            android:textStyle="bold"
            android:padding="@dimen/marginSmall"
            android:background="@android:color/black"
            android:textColor="@android:color/white"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_alignParentBottom="true"
            android:layout_marginBottom="@dimen/marginMedium"
            android:layout_marginLeft="@dimen/marginMedium"/>

        <!-- VALORACION -->

        <TextView
            android:id="@+id/tvRating"
            android:layout_toRightOf="@+id/tvName"
            android:text="@string/rating_def"
            android:textSize="@dimen/textSizeSmallMedium"
            android:textStyle="bold"
            android:padding="@dimen/marginSmall"
            android:background="@android:color/holo_blue_light"
            android:textColor="@android:color/white"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_marginBottom="@dimen/marginMedium" />

        <!-- DISTANCIA -->

        <TextView
            android:id="@+id/tvDistance"
            android:text="@string/distance_def"
            android:textSize="@dimen/textSizeSmall"
            android:padding="@dimen/marginSmall"
            android:background="@color/colorDistance"
            android:textColor="@android:color/white"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentRight="true"
            android:layout_alignParentTop="true"
            android:layout_marginTop="@dimen/marginMedium"
            android:layout_marginRight="@dimen/marginMedium"/>

    </RelativeLayout>

</LinearLayout>
```

