/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author ZX
 */
public class Produit {
    
    private int _id;
    private String description;
    private int prix;
    private int STOCK;
    private String image;
    private Categorie idCatA;

    public Categorie getIdCatA() {
        return idCatA;
    }

    public void setIdCatA(Categorie idCatA) {
        this.idCatA = idCatA;
    }

    public Produit(int _id) {
        this._id = _id;
    }

    public Produit() {
    }

    public Produit(int _id, String description, int prix, int STOCK, String image) {
        this._id = _id;
        this.description = description;
        this.prix = prix;
        this.STOCK = STOCK;
        this.image = image;
        this.idCatA = idCatA;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   // public int getIdCatA() {
   //     return idCatA;
   // }

   // public void setIdCat(int idCat) {
   //     this.idCatA = idCat;
   // }

    @Override
    public String toString() {
        return "Produit{" + "_id=" + _id + ", description=" + description + ", prix=" + prix + ", STOCK=" + STOCK + ", image=" + image + ", idCatA=" + idCatA + '}';
    }

    public Produit(String description) {
        this.description = description;
    }



  
}
