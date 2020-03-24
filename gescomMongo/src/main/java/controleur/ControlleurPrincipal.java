/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.CategorieDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import vue.CategorieVue;
import vue.Principale2;

/**
 *
 * @author ZX
 */
public class ControlleurPrincipal implements ActionListener{
private Principale2 principale;
CategorieDao CaDao = new CategorieDao();
CategorieVue Cavue= new CategorieVue();

    public ControlleurPrincipal() {
        principale = new Principale2();
        principale.setVisible(true);
        this.principale.getNewMiCat().addActionListener(this);
        this.principale.getUpMiCat().addActionListener(this);
        this.principale.getDelMiCat().addActionListener(this);
        this.principale.getNewMiPro().addActionListener(this);
        this.principale.getUpMiPro().addActionListener(this);
        this.principale.getDelMiPro().addActionListener(this);  
        this.principale.getNewMICmd().addActionListener(this);
        this.principale.getDelCmdMI().addActionListener(this);
        this.principale.getUpcmdMi().addActionListener(this);
        this.principale.getContenirMI().addActionListener(this);

        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource()==this.principale.getNewMiCat())||(e.getSource()==this.principale.getUpMiCat())
                ||(e.getSource()==this.principale.getDelMiCat())){
            ControlleurCat controlCat= new ControlleurCat(); 

                          //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        else if((e.getSource()==this.principale.getNewMiPro())||
                (e.getSource()==this.principale.getUpMiPro())||(e.getSource()==this.principale.getDelMiPro())){
         ControlleurPro controlpro= new ControlleurPro(); 
        }
        else if((e.getSource()==this.principale.getNewMICmd())||
                (e.getSource()==this.principale.getDelCmdMI())||(e.getSource()==this.principale.getUpcmdMi())){
         ControlleurComande controlcmd= new ControlleurComande(); 
   }      else if(e.getSource()==this.principale.getContenirMI()){
         ControlleurContenir controlC= new ControlleurContenir(); 
   }
        
    }}
    
    
    
  