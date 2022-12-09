package com.mycompany.poe20221107.ecommerce.model;



import java.util.ArrayList;

public class Basket {
    private ArrayList<BasketItem> items = new ArrayList<>();

    public ArrayList<BasketItem> getItems() {
        return items;
    }
    
    public void addItem(BasketItem article){
        items.add(article);
    }
    
    public BasketItem getItem(int articleid){
        for(BasketItem item : items){
            if(item.getArticle().getId() == articleid){
                return item;
            }
        }
        return null;
    }
}