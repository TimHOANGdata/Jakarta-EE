
package com.poe20221107;

import java.util.ArrayList;


public class Stock {
    private Produit produit;

    public Stock(Produit produit) {
        ArrayList<Produit> stock = new ArrayList<>();
        stock.add(produit);
    }
}

