/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.mongodb.BasicDBObject;
import dao.CategorieDao;
import dao.ComandeDao;
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
import modele.Comande;
import vue.CategorieVue;
import vue.ComandeVUe;

/**
 *
 * @author ZX
 */
public class ControlleurComande implements ActionListener,MouseListener{
    
    
        private ComandeVUe cmdVue;
    private ComandeDao cmdDao;
    ComandeDao CaDao = new ComandeDao();
    List<ComandeDao> Cata = new ArrayList();
    List<Comande> lcmd;
   
    DefaultTableModel modelListeCmd = new DefaultTableModel();

    public ControlleurComande() {
                this.cmdDao= new ComandeDao();
        this.cmdVue= new ComandeVUe();
        this.cmdVue.setVisible(true);
        this.cmdVue.getBtnInsertCmde().addActionListener(this);
        this.cmdVue.getBtnDeletteCmd().addActionListener(this);
        this.cmdVue.getBtnUpdateCmde().addActionListener(this);
        this.cmdVue.getBtnResetCmd().addActionListener(this);
        this.cmdVue.getTabComand().addMouseListener(this);
        afficherListCmd();
    }

    public ControlleurComande(ComandeVUe cmdVue) {
        this.cmdVue = cmdVue;
    }

    public ControlleurComande(ComandeDao cmdDao) {
        this.cmdDao = cmdDao;
    }

    public ComandeVUe getCmdVue() {
        return cmdVue;
    }

    public void setCmdVue(ComandeVUe cmdVue) {
        this.cmdVue = cmdVue;
    }

    public ComandeDao getCmdDao() {
        return cmdDao;
    }

    public void setCmdDao(ComandeDao cmdDao) {
        this.cmdDao = cmdDao;
    }

    public ComandeDao getCaDao() {
        return CaDao;
    }

    public void setCaDao(ComandeDao CaDao) {
        this.CaDao = CaDao;
    }

    public List<ComandeDao> getCata() {
        return Cata;
    }

    public void setCata(List<ComandeDao> Cata) {
        this.Cata = Cata;
    }

    public DefaultTableModel getModelListeCmd() {
        return modelListeCmd;
    }

    public void setModelListeCmd(DefaultTableModel modelListeCmd) {
        this.modelListeCmd = modelListeCmd;
    }
    
         public int maxCmd(){
         List<Comande> listeCmd=this.cmdDao.getALL();
         List<Integer> listeId= new ArrayList<>();
         
         for (Comande cat: listeCmd){
             listeId.add(cat.getIdCommande());
         }
         if(listeId.isEmpty()){
         listeId.add(0);
     }
         return Collections.max(listeId);
     }

    @Override
    public String toString() {
        return "ControlleurComande{" + "cmdVue=" + cmdVue + ", cmdDao=" + cmdDao + ", CaDao=" + CaDao + ", Cata=" + Cata + ", modelListeCmd=" + modelListeCmd + '}';
    }
    
         public void afficherListCmd(){
        modelListeCmd = new DefaultTableModel();
        modelListeCmd.addColumn("_Id");
        modelListeCmd.addColumn("nomClient");
        modelListeCmd.addColumn("DateCmde");
        
       lcmd = this.cmdDao.getALL();
        
        for (Comande cmd: lcmd){
               modelListeCmd.addRow(new Object[]{cmd.getIdCommande(), cmd.getNomClient(), cmd.getDateCmde()});
        }
        
        this.cmdVue.getTabComand().setModel(modelListeCmd);
                
     }
    

    @Override
    public void actionPerformed(ActionEvent e) {
               if (e.getSource()== this.cmdVue.getBtnInsertCmde()){
           Comande cmd = new Comande();
           cmd.setIdCommande(Integer.parseInt(this.cmdVue.getTXTidCmde().getText()));
           cmd.setNomClient(this.cmdVue.getTXTnomClient().getText());
           cmd.setDateCmde(this.cmdVue.getTXTdateCmde().getText());
           
           this.cmdDao.insert(cmd);
           afficherListCmd();
           this.cmdVue.getTXTidCmde().setText(Integer.toString((maxCmd()+1)));
            JOptionPane.showMessageDialog(null,"Comande inserée");
       } else if(e.getSource()== this.cmdVue.getBtnDeletteCmd()){
           Comande cmd = new Comande();
           cmd.setIdCommande(Integer.parseInt(this.cmdVue.getTXTidCmde().getText()));
           this.cmdDao.delette(cmd);
           afficherListCmd();
           this.cmdVue.getTXTidCmde().setText(Integer.toString((maxCmd()+1)));
           JOptionPane.showMessageDialog(null,"Categorie SUPRIME");           
       }else if(e.getSource()== this.cmdVue.getBtnResetCmd()){    
           Comande comande = new Comande();
           this.cmdDao.reset(comande);
                   afficherListCmd();
           JOptionPane.showMessageDialog(null,"Toute les Categories suprimés"); 
       
       }else if(e.getSource()== this.cmdVue.getBtnUpdateCmde()){
         Comande cmd = new Comande();
           cmd.setIdCommande(Integer.parseInt(this.cmdVue.getTXTidCmde().getText()));
           cmd.setNomClient(this.cmdVue.getTXTnomClient().getText());
           this.cmdDao.update(cmd);
           afficherListCmd();
           this.cmdVue.getTXTidCmde().setText(Integer.toString((maxCmd()+1)));
           JOptionPane.showMessageDialog(null,"Categorie Updaté");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
