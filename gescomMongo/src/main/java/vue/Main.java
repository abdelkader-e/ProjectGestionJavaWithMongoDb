/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.ControlleurPrincipal;
import dao.CategorieDao;
import dao.ComandeDao;
import javax.swing.JTable;
import modele.Categorie;

/**
 *
 * @author ZX
 */
public class Main {
    public static void main(String[] args){
       // CategorieDao catdao = new CategorieDao();
        //System.out.println(catdao.getALL());
        //catdao.update(new Categorie(2,"DVD"));
      
        //System.out.println(catdao.getOne(new Categorie(2)));
        //Principale2 principale = new Principale2();
        //principale.setVisible(true);
                // Data to be displayed in the JTable 
                
                
       // String[][] data = { 
        //    { "Kundan Kumar Jha", "4031", "CSE" }, 
        //    { "Anand Jha", "6014", "IT" } 
        //}; 
        //String[] columnNames = { "Name", "Roll Number", "Department" }; 
         // JTable tabCat = new JTable(data, columnNames);
          //  tabCat = new JTable(data, columnNames);    
        
        
          ControlleurPrincipal controlPrincipAl = new ControlleurPrincipal();
        // tabCat = new JTable(data, columnNames);
       // ComandeDao cmd=new ComandeDao();
        // System.out.println(cmd.getALL());
    }
    
}
