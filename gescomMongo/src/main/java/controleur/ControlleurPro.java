/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.mongodb.BasicDBObject;
import dao.CategorieDao;
import dao.ProduitDao;
import dao.ProduitDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modele.Categorie;
import modele.Produit;
import modele.Produit;
import vue.ProduitVue;
import vue.ProduitVue;


public class ControlleurPro implements ActionListener{
  

    private ProduitVue proVue;
    private ProduitDao proDao;
    CategorieDao CaDao = new CategorieDao();
    
  

    public ControlleurPro() {
        this.proDao= new ProduitDao();
        this.proVue= new ProduitVue();
        this.proVue.setVisible(true);
        this.proVue.getBtnInsertPro().addActionListener(this);
        this.proVue.getBtnDeletePro().addActionListener(this);
        this.proVue.getBtnUpdatePro().addActionListener(this);
        this.proVue.getBtnResetPro().addActionListener(this);
        afficherTableauPro();
        ajoutComboCat();
        
    }
    public void afficherTableauPro(){
            DefaultTableModel modelListeCat = new DefaultTableModel();
        modelListeCat.addColumn("_id");
        modelListeCat.addColumn("descrption");
        modelListeCat.addColumn("prix");
        modelListeCat.addColumn("STOCK");
        modelListeCat.addColumn("image");
        modelListeCat.addColumn("libelle");
        
        List<Produit> Pro = this.proDao.getALL();
        
        for (Produit cat: Pro){
               modelListeCat.addRow(new Object[]{cat.getId(), cat.getDescription(), cat.getPrix(), cat.getSTOCK(), cat.getImage(), cat.getIdCatA().getLibelle().toString()});
        }
        
        this.proVue.getProTab().setModel(modelListeCat);
    }


    public ControlleurPro(ProduitVue proVue) {
        this.proVue = proVue;
    }

    public ControlleurPro(ProduitDao proDao) {
        this.proDao = proDao;
    }
    
    
       
    @Override
    public void actionPerformed(ActionEvent e) {
        
                
        
       if (e.getSource()== this.proVue.getBtnInsertPro()){
           Produit produit = new Produit();
           produit.setId(Integer.parseInt(this.proVue.getTXTidproduit().getText()));
           produit.setDescription(this.proVue.getTXTdescr().getText());
           BasicDBObject docCat = new BasicDBObject();
           produit.setPrix(Integer.parseInt(this.proVue.getTXTprix().getText()));
           produit.setSTOCK(Integer.parseInt(this.proVue.getTXTStock().getText()));
           produit.setImage(this.proVue.getTXTImage().getText());
           produit.setIdCatA(this.CaDao.getCat2(new Categorie (this.proVue.getComboCat().getSelectedItem().toString())));
           System.out.print("test btn"+produit);
           this.proDao.insert(produit);    
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Produit inserée");
           
       } else if(e.getSource()== this.proVue.getBtnDeletePro()){
           Produit produit = new Produit();
           produit.setId(Integer.parseInt(this.proVue.getTXTidproduit().getText()));
           this.proDao.delette(produit);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Produit SUPRIME"); 
           
       }else if(e.getSource()== this.proVue.getBtnResetPro()){    
           Produit produit = new Produit();
           this.proDao.reset(produit);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Toute les Produits suprimés"); 
       
       }else if(e.getSource()== this.proVue.getBtnUpdatePro()){
           Produit produit = new Produit();
           produit.setId(Integer.parseInt(this.proVue.getTXTidproduit().getText()));
           produit.setDescription(this.proVue.getTXTdescr().getText());
           produit.setPrix(Integer.parseInt(this.proVue.getTXTprix().getText()));
           produit.setSTOCK(Integer.parseInt(this.proVue.getTXTStock().getText()));
           produit.setImage(this.proVue.getTXTImage().getText());
          produit.setIdCatA(this.CaDao.getCat2(new Categorie (this.proVue.getComboCat().getSelectedItem().toString())));
           this.proDao.update(produit);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Produit Updaté");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
       
       public void ajoutComboCat(){
           List<Categorie>listeCat =this.CaDao.getALL();
           for(Categorie idCat: listeCat){
               this.proVue.getComboCat().addItem((idCat.getLibelle()));
               
           }
                   
       
    
    
    
}}

    
