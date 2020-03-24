/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.mongodb.BasicDBObject;
import dao.CategorieDao;
import dao.ComandeDao;
import dao.ContenirDao;
import dao.ProduitDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import modele.Categorie;
import modele.Comande;
import modele.Contenir;
import modele.Produit;
import vue.ContenirVue;
import vue.ProduitVue;

/**
 *
 * @author ZX
 */
public class ControlleurContenir implements ActionListener,MouseListener{
    
    
    
    
    ContenirVue ctnVue;
    ContenirDao ctnDao;
    
    private ProduitDao proDao;
    ComandeDao cmdDao = new ComandeDao();
    CategorieDao CaDao = new CategorieDao();

    public ControlleurContenir() {
        this.proDao= new ProduitDao();
        
        this.ctnVue= new ContenirVue();
        this.ctnVue.setVisible(true);
      this.ctnVue.getBtnCtnInsert().addActionListener(this);
      this.ctnVue.getBtnDelCtn().addActionListener(this);
      this.ctnVue.getBtnResCtn().addActionListener(this);
      this.ctnVue.getBtnUpdCtn().addActionListener(this);
        ajoutComboCtn();
          
        
    }
       
    
    
           public void ajoutComboCtn(){
           
           List<Comande>listeCmd =this.cmdDao.getALL();
           for(Comande idCmd: listeCmd){
               this.ctnVue.getCmbBoxCmde().addItem((idCmd.getNomClient()));}
           List<Produit>listeProd =this.proDao.getALL();
           for(Produit idProd: listeProd){
               this.ctnVue.getCmbBoxDescription().addItem((idProd.getDescription()));
               
               
           }}

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource()== this.ctnVue.getBtnCtnInsert()){
           Contenir contenir = new Contenir();
           
           contenir.setQuantite(Integer.parseInt(this.ctnVue.getTXTQuantite().getText()));
           
           contenir.setCmd(this.cmdDao.getOne2(new Comande((this.ctnVue.getCmbBoxCmde().getSelectedItem().toString()))));
          contenir.setProd(this.proDao.getOne2(new Produit(this.ctnVue.getCmbBoxDescription().getSelectedItem().toString())));
           //System.out.print("test btn"+contenir);
            this.ctnDao.insert(contenir);    
          // afficherTableauPro();
           JOptionPane.showMessageDialog(null,contenir);
           
       }/* else if(e.getSource()== this.ctnVue.getBtnDeletePro()){
           Produit contenir = new Produit();
           contenir.setId(Integer.parseInt(this.ctnVue.getTXTidcontenir().getText()));
           this.proDao.delette(contenir);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Produit SUPRIME"); 
           
       }else if(e.getSource()== this.ctnVue.getBtnResetPro()){    
           Produit contenir = new Produit();
           this.proDao.reset(contenir);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Toute les Produits suprimés"); 
       
       }else if(e.getSource()== this.ctnVue.getBtnUpdatePro()){
           Produit contenir = new Produit();
           contenir.setId(Integer.parseInt(this.ctnVue.getTXTidcontenir().getText()));
           contenir.setDescription(this.ctnVue.getTXTdescr().getText());
           contenir.setPrix(Integer.parseInt(this.ctnVue.getTXTprix().getText()));
           contenir.setSTOCK(Integer.parseInt(this.ctnVue.getTXTStock().getText()));
           contenir.setImage(this.ctnVue.getTXTImage().getText());
          contenir.setIdCatA(this.CaDao.getCat2(new Categorie (this.ctnVue.getComboCat().getSelectedItem().toString())));
           this.proDao.update(contenir);
           afficherTableauPro();
           JOptionPane.showMessageDialog(null,"Produit Updaté");
        
        */
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
