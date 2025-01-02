package com.example.dev;

public class MenuItem {
    private String name;
    private double price;
    private int imageResource;

    public MenuItem(String name, double price, int imageResource) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getImageResource() { return imageResource; }
} 