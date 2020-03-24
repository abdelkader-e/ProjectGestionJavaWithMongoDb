/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author ZX
 */
public class Categorie {
    private int idcat;
    private String libelle;

    public int getIdcat() {
        return idcat;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }
    

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie() {
    }

    public Categorie(int idcat) {
        this.idcat = idcat;
    }

    public Categorie(int idcat, String libelle) {
        this.idcat = idcat;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idcat=" + idcat + ", libelle=" + libelle + '}';
    }



    public boolean equals(Object obj) {
        if (obj instanceof Categorie){
            Categorie cat= (Categorie)obj;
            return this.idcat==cat.idcat && this.libelle ==cat.libelle;
        }
        return true;}
    }
    
    
    

