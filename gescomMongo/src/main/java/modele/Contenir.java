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
public class Contenir {
    
    private int quantite;
    Comande cmd;
    Produit prod;
    



    
    
    public Contenir() {
    }

    public Contenir(int quantite, Comande cmd, Produit prod) {
        this.quantite = quantite;
        this.cmd = cmd;
        this.prod = prod;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Comande getCmd() {
        return cmd;
    }

    public void setCmd(Comande cmd) {
        this.cmd = cmd;
    }

    public Produit getProd() {
        return prod;
    }

    public void setProd(Produit prod) {
        this.prod = prod;
    }

    @Override
    public String toString() {
        return "Contenir{" + "quantite=" + quantite + ", cmd=" + cmd + ", prod=" + prod + '}';
    }

    
    
    
    
}
