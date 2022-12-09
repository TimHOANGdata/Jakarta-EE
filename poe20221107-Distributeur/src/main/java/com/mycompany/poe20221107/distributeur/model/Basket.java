
package com.mycompany.poe20221107.distributeur.model;

import java.util.ArrayList;


public class Basket {
    private ArrayList<Product> basket= new ArrayList<>();
    public ArrayList<Product> getBasket() {
        return basket;
    }
    public void addProduct(Product product){
        basket.add(product);
    }
    
    public Product findProduct(int productId){
        for(Product i : basket){
            if(i.getId() == productId){
                return i;
            }
        }
        return null;
    }
    public double calculateTotalPrice(){
        double sum = 0;
        for(Product i:basket){
            sum += i.getPrice()*i.getQuantity();
        }return sum;
    }
}
