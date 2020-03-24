/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CategorieDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modele.Categorie;
import vue.CategorieVue;

/**
 *
 * @author ZX
 */
public class ControlleurCat implements ActionListener, MouseListener{

    private CategorieVue catVue;
    private CategorieDao catDao;
    CategorieDao CaDao = new CategorieDao();
    List<CategorieDao> Cata = new ArrayList();
    List<Categorie> catt;
    DefaultTableModel modelListeCat = new DefaultTableModel();

    public CategorieVue getCatVue() {
        catt = this.catDao.getALL();
        return catVue;
    }

    public CategorieDao getCatDao() {
        return catDao;
    }

    public CategorieDao getCaDao() {
        return CaDao;
    }

    public List<CategorieDao> getCata() {
        return Cata;
    }

    public List<Categorie> getCatt() {
        return catt;
    }

    public DefaultTableModel getModelListeCat() {
        return modelListeCat;
    }
    
    
    

    public ControlleurCat() {
        this.catDao= new CategorieDao();
        this.catVue= new CategorieVue();
        this.catVue.setVisible(true);
        this.catVue.getBtnInsertCat().addActionListener(this);
        this.catVue.getBtnDeleteCat().addActionListener(this);
        this.catVue.getBtnUpdateCat().addActionListener(this);
        this.catVue.getBtnResetCat().addActionListener(this);
        this.catVue.getTabCat().addMouseListener(this);
        afficherListCat();
        maxId();
        
              }
    
     public void afficherListCat(){
        modelListeCat = new DefaultTableModel();
        modelListeCat.addColumn("ID Catégorie");
        modelListeCat.addColumn("Libelle catégorie");
        
      catt = this.catDao.getALL();
        
        for (Categorie cat: catt){
               modelListeCat.addRow(new Object[]{cat.getIdcat(), cat.getLibelle()});
        }
        
        this.catVue.getTabCat().setModel(modelListeCat);
                
     }
     public int maxId(){
         List<Categorie> listeCat=this.catDao.getALL();
         List<Integer> listeId= new ArrayList<>();
         
         for (Categorie cat: listeCat){
             listeId.add(cat.getIdcat());
         }
         if(listeId.isEmpty()){
         listeId.add(0);
     }
         return Collections.max(listeId);
     }

    public ControlleurCat(CategorieVue catVue) {
        this.catVue = catVue;
    }

    public ControlleurCat(CategorieDao catDao) {
        this.catDao = catDao;
    }
    
    
       
    @Override
    public void actionPerformed(ActionEvent e) {     
       if (e.getSource()== this.catVue.getBtnInsertCat()){
           Categorie categorie = new Categorie();
           categorie.setIdcat(Integer.parseInt(this.catVue.getTXTidcat().getText()));
           categorie.setLibelle(this.catVue.getTXTlibelle().getText());
           this.catDao.insert(categorie);
           afficherListCat();
           this.catVue.getTXTidcat().setText(Integer.toString((maxId()+1)));
            JOptionPane.showMessageDialog(null,"Categorie inserée");
       } else if(e.getSource()== this.catVue.getBtnDeleteCat()){
           Categorie categorie = new Categorie();
           categorie.setIdcat(Integer.parseInt(this.catVue.getTXTidcat().getText()));
           this.catDao.delette(categorie);
           afficherListCat();
           this.catVue.getTXTidcat().setText(Integer.toString((maxId()+1)));
           JOptionPane.showMessageDialog(null,"Categorie SUPRIME");           
       }else if(e.getSource()== this.catVue.getBtnResetCat()){    
           Categorie categorie = new Categorie();
           this.catDao.reset(categorie);
           afficherListCat();
           JOptionPane.showMessageDialog(null,"Toute les Categories suprimés"); 
       
       }else if(e.getSource()== this.catVue.getBtnUpdateCat()){
           Categorie categorie = new Categorie();
           categorie.setIdcat(Integer.parseInt(this.catVue.getTXTidcat().getText()));
           categorie.setLibelle(this.catVue.getTXTlibelle().getText());
           this.catDao.update(categorie);
           afficherListCat();
           this.catVue.getTXTidcat().setText(Integer.toString((maxId()+1)));
           JOptionPane.showMessageDialog(null,"Categorie Updaté");
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

    @Override
    public void mouseClicked(MouseEvent e) {
        int ligne=this.catVue.getTabCat().getSelectedRow();        
        
        this.catVue.getTXTidcat().setText(this.modelListeCat.getValueAt(ligne,0).toString());
        this.catVue.getTXTlibelle().setText(this.modelListeCat.getValueAt(ligne,1).toString());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

