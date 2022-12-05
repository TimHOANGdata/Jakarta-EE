
package com.poe20221107;



public class Personne{
    private String nom;
    private String prenom;
    
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }
    public Personne(){
    }
    @Override
    public String toString(){
        return "Personne: "+nom+" "+prenom;
    } 

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
}
