/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ams02.models;

/**
 *
 * @author Kiet Nguyen
 */
public abstract class User {
    private String name;
    private String customerId;
    
    public User() {
        
    }
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name  = name; }
    
    public String getCustomerId() { return customerId; }
    
    public void setCustomerId(String customerId) throws Exception {
        if (customerId.matches("[0-9]+") && customerId.length()==12)
            this.customerId  = customerId;
        else
            throw new Exception("Ma khac hang khong hop le");
    }
}
