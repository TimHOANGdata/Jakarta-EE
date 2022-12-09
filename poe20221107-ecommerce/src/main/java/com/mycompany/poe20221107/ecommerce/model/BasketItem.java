
package com.mycompany.poe20221107.ecommerce.model;

public class BasketItem {
    
    private Article article;
    private int quantity; 

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}