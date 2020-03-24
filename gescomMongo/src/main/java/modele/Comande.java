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
public class Comande {
    
    private int idCommande;
    private String dateCmde;
    private String nomClient;

    public Comande() {
    }

    public Comande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Comande(String nomClient) {
        this.nomClient = nomClient;
    }
    

    public Comande(int idCommande, String dateCmde, String nomClient) {
        this.idCommande = idCommande;
        this.dateCmde = dateCmde;
        this.nomClient = nomClient;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getDateCmde() {
        return dateCmde;
    }

    public void setDateCmde(String dateCmde) {
        this.dateCmde = dateCmde;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @Override
    public String toString() {
        return "Comande{" + "_id=" + idCommande + ", dateCmde=" + dateCmde + ", nomClient=" + nomClient + '}';
    }
    
    
    
    
    
}
