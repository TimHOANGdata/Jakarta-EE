
package com.mycompany.poe20221107.distributeur.model;

import java.util.ArrayList;


public class Stock {
    private ArrayList<Product> stock = new ArrayList<>();
    private int nextId = 1;

    public Stock() {
        addStock(new Product("coca-cola",5,11));
        addStock(new Product("7Up",4,14));
        addStock(new Product("Water",2,15));
        addStock(new Product("Coffee",1,6));
        addStock(new Product("Chocolate",5,5));
        addStock(new Product("Candy",6,4));
        
    }

    public ArrayList<Product> getStock() {
        return stock;
    }

    public void addStock(Product product) {
        nextId++;
        product.setId(nextId);
        stock.add(product);
    }
    public Product findProduct(int id){
        for(Product i : stock){
            if(id == i.getId()){
                return i;
            }
                
        }return null;
    }
    
    
}
