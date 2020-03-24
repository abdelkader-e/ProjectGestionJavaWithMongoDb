/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import controleur.ConecMongo;
import java.util.List;
import modele.Categorie;
import modele.Contenir;

/**
 *
 * @author ZX
 */
public class ContenirDao implements InterfaceDao<Contenir>{
    
    private DB db;
    private DBCollection collectionContenir; 
    

    public ContenirDao() {
        this.db=ConecMongo.getDb();
        this.collectionContenir=this.db.getCollection("contenir");
        
    }

    @Override
    public void insert(Contenir t) { 
        BasicDBObject docCnt = new BasicDBObject();
        BasicDBObject docCmd = new BasicDBObject();
        BasicDBObject docPro = new BasicDBObject();
        docCmd.append("_id", t.getCmd().getIdCommande())
                .append("nomClient", t.getCmd().getIdCommande())
                .append("dateCmde", t.getCmd().getIdCommande())
                ;
        BasicDBObject docCat = new BasicDBObject();
        
     
        docPro.append("_id", t.getProd().getId()).append("description", t.getProd().getDescription())
                .append("prix", t.getProd().getPrix()).append("STOCK", t.getProd().getSTOCK())
               .append("image", t.getProd().getImage()).append("categorie", t.getProd().getIdCatA())
                //append("categorie", docCat.ge)
                ;
        
        docCnt.append("comande", docCmd).append("produit", docPro).append("quantite", t.getQuantite());
    
        
        this.collectionContenir.insert(docCnt);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Contenir t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delette(Contenir t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contenir> getALL() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contenir getOne(Contenir t) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
