package com.poe20221107;

public class Database {
    public void connect() throws Exception{
        System.out.println("Connexion à la base de données");
        int i=5/0;
    }
    public String readData(){
        return "fake data from database";
    }
}
