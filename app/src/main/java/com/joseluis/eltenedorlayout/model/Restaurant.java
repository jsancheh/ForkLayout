package com.joseluis.eltenedorlayout.model;

/**
 * Modelo de datos
 *
 * Author: José Luis Sánchez
 */
public class Restaurant {


    private int id;
    private String name;
    private String rating;
    private int res;
    private String distance;
    private String promo;

    public Restaurant(){
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }
}
