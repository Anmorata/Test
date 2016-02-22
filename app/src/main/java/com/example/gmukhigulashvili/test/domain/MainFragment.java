package com.example.gmukhigulashvili.test.domain;

/**
 * Created by g.mukhigulashvili on 2/18/2016.
 */
public class MainFragment {

    private String model;
    private String brand;
    private int photo;

    public MainFragment(){}
    public MainFragment(String m, String b, int p){
        model = m;
        brand = b;
        photo = p;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
