/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import controleur.ConecMongo;
import java.util.ArrayList;
import java.util.List;
import modele.Categorie;
import modele.Comande;

/**
 *
 * @author ZX
 */
public class ComandeDao implements InterfaceDao<Comande>{
    
    private DB db;
    private DBCollection collectionComande; 

    public ComandeDao() {
        this.db=ConecMongo.getDb();
        this.collectionComande=this.db.getCollection("comande");
        
    }
    
                public void reset(Comande t) {
        BasicDBObject docCmd = new BasicDBObject();
        this.collectionComande.remove(docCmd);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Comande t) {
        
        BasicDBObject docCmd = new BasicDBObject();
        docCmd.append("_id", t.getIdCommande()).append("nomClient", t.getNomClient()).append("dateCmde", t.getDateCmde());
        this.collectionComande.insert(docCmd);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comande t) {
        BasicDBObject docCmdOld = new BasicDBObject();
        docCmdOld.append("_id", t.getIdCommande());
        BasicDBObject docCmdnew = new BasicDBObject();
        docCmdnew.append("_id", t.getIdCommande()).append("nomClient", t.getNomClient()).append("dateCmde", t.getDateCmde());
        this.collectionComande.update(docCmdOld, docCmdnew);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delette(Comande t) {
        BasicDBObject docCat = new BasicDBObject();
        docCat.append("_id", t.getIdCommande());
        this.collectionComande.remove(docCat);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comande> getALL() {
        List<Comande> listeCmd= new ArrayList<>();
        DBCursor cursor = this.collectionComande.find();
        while(cursor.hasNext()){
            DBObject objcmd = cursor.next();
            Comande cmd = new Comande();
            cmd.setIdCommande((int)objcmd.get("_id"));
            cmd.setNomClient(objcmd.get("nomClient").toString());
            cmd.setDateCmde(objcmd.get("dateCmde").toString());
            listeCmd.add(cmd);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        return listeCmd;
    }
    
    @Override
    public Comande getOne(Comande t) {
         Comande cmd=new Comande();
        
        BasicDBObject docCat= new BasicDBObject("_id", t.getIdCommande());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionComande.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objcmd = objCur.next();
        
        //System.out.println("objcat"+objCat);
        

            cmd.setIdCommande((int)objcmd.get("_id"));
            cmd.setNomClient(objcmd.get("nomClient").toString());
            cmd.setDateCmde(objcmd.get("dateCmde").toString());
            
        return cmd;
    }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   

    public Comande getOne2(Comande t) {
         Comande cmd=new Comande();
        
        BasicDBObject docCat= new BasicDBObject("nomClient", t.getNomClient());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionComande.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objcmd = objCur.next();
        
        //System.out.println("objcat"+objCat);
        

            cmd.setIdCommande((int)objcmd.get("_id"));
            cmd.setNomClient(objcmd.get("nomClient").toString());
            cmd.setDateCmde(objcmd.get("dateCmde").toString());
            
        return cmd;


}}
    

