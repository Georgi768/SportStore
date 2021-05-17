package com.SportStore;

import java.util.ArrayList;

public class Basket implements IPriceTag {
    private boolean isAvailable;
    private int number;
    private ArrayList<Product> products;

    public Basket(int number) {
        this.number = number;
        this.products = new ArrayList<>();
        this.isAvailable = true;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isBasketAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean active) {
        this.isAvailable = active;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public boolean addProducts(Product product) {
        return this.products.add(product);
    }

    /**
     * This method shows the total price of all the products added
     * @return returns the total sum
     */
    @Override
    public double getPrice() {
        double productPrices = 0;
        for (Product aProduct : this.products) {
            productPrices = productPrices + aProduct.getPrice();
        }
        return productPrices;
    }
}
