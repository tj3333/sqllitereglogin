package com.example.santoshyadav.sqllitereglogin.Model;

public class BookPlacesModelClass {

    String id,name,distance,price;


    public BookPlacesModelClass(String id, String name, String distance,String price) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.price=price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }


}
