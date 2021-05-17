package com.SportStore;

public class Product implements IPriceTag {
    private String QRCode;
    private IPriceTag priceTag;
    private double price;
    private ProductType productType;

    public Product(String QRCode, ProductType type, double price) {
        this.QRCode = QRCode;
        this.productType = type;
        this.price = price;
    }

    public String getQRCode() {
        return this.QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public IPriceTag getPriceTag() {
        return this.priceTag;
    }

    public double getPrice() {
        return price;
    }

}
