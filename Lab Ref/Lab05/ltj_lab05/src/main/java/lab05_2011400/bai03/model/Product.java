/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05_2011400.bai03.model;

/**
 *
 * @author Kiet Nguyen
 */
public class Product {
    private String productId, name, unit;
    private double price;
    private String provider;
    
    public Product() {}
    
    public Product(String id, String name, String unit, double price, String provider) {
        this.productId = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.provider = provider;
    }
    
    public void setProductId(String id) {
        this.productId = id;
    }
    public String getProductId() {
        return this.productId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public String getProvider() {
        return this.provider;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
}
