package com.example.santoshyadav.sqllitereglogin.Model;

public class ExpenditurePlacesModelClass {

    String id,name,last_yr_cost,time;

    public ExpenditurePlacesModelClass(String id, String name, String last_yr_cost, String time) {
        this.id = id;
        this.name = name;
        this.last_yr_cost = last_yr_cost;
        this.time = time;
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

    public String getLast_yr_cost() {
        return last_yr_cost;
    }

    public void setLast_yr_cost(String last_yr_cost) {
        this.last_yr_cost = last_yr_cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
