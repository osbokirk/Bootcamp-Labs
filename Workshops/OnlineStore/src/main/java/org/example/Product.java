package org.example;

public class Product {
    private String SKU;
    private String productName;
    private double price;
    private String category;

    public Product(String SKU, String productName, double price, String category) {
        this.SKU = SKU;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
