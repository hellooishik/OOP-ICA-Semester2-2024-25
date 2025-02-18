/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.borobikessystem;

public class Bike {
    private String code;
    private String make;
    private String model;
    private String color;
    private String ageRange;
    private String material;
    private String features;
    private double price;
    private int stock;
    private boolean assembled;

    public Bike(String code, String make, String model, String color, String ageRange, String material, String features, double price, int stock, boolean assembled) {
        this.code = code;
        this.make = make;
        this.model = model;
        this.color = color;
        this.ageRange = ageRange;
        this.material = material;
        this.features = features;
        this.price = price;
        this.stock = stock;
        this.assembled = assembled;
    }

    public String getCode() { return code; }
    public String getMakeModel() { return make + " " + model; }
    public String getColor() { return color; }
    public String getAgeRange() { return ageRange; }
    public String getMaterial() { return material; }
    public String getFeatures() { return features; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public boolean isAssembled() { return assembled; }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }
}
