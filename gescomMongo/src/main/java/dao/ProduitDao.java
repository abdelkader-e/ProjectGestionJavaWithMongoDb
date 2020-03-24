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
import modele.Produit;

/**
 *
 * @author ZX
 */
public class ProduitDao implements InterfaceDao<Produit>{
    
        
    
    private DB db;
    private DBCollection collectionProduit; 

    public ProduitDao() {
        this.db=ConecMongo.getDb();
        this.collectionProduit=this.db.getCollection("produit");
        
    }
    
    

    @Override
    public void insert(Produit t) {
        BasicDBObject docPro = new BasicDBObject();
        BasicDBObject docCat = new BasicDBObject();
        docCat.append("idcat", t.getIdCatA().getIdcat())
                .append("libelle", t.getIdCatA().getLibelle());
        docPro.append("_id", t.getId()).append("description", t.getDescription())
                .append("prix", t.getPrix()).append("STOCK", t.getSTOCK())
               .append("image", t.getImage()).append("categorie", docCat);
                
        System.out.println(docPro);
        
        this.collectionProduit.insert(docPro);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Produit t) {
        BasicDBObject docProOld = new BasicDBObject();
        docProOld.append("_id", t.getId());
        BasicDBObject docProNew = new BasicDBObject();
        BasicDBObject docCat = new BasicDBObject();
                docCat.append("idcat", t.getIdCatA().getIdcat())
                .append("libelle", t.getIdCatA().getLibelle());
        docProNew.append("_id", t.getId()).append("description", t.getDescription())
                .append("prix", t.getPrix()).append("STOCK", t.getSTOCK())
                .append("image", t.getPrix()).append("categorie", docCat);
                ;
        this.collectionProduit.update(docProOld, docProNew);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delette(Produit t) {
                BasicDBObject docPro = new BasicDBObject();
        docPro.append("_id", t.getId());
        this.collectionProduit.remove(docPro);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> getALL() {
        List<Produit> listePro= new ArrayList<>();
        DBCursor cursor = this.collectionProduit.find();
        
        while(cursor.hasNext()){
            DBObject objPro = cursor.next();
            Produit Pro = new Produit();
            Pro.setId((int)objPro.get("_id"));
            Pro.setDescription(objPro.get("description").toString());
            Pro.setPrix((int)objPro.get("prix"));
            Pro.setSTOCK((int)objPro.get("STOCK"));
            Pro.setImage(objPro.get("image").toString());
            DBObject objCat =(DBObject) objPro.get("categorie");
            Pro.setIdCatA(new Categorie((int)objCat.get("idcat"),
                    objCat.get("libelle").toString())); 
            
            
            listePro.add(Pro);
        }
                
        return listePro;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produit getOne(Produit t) {
                Produit Pro =new Produit();
        
        BasicDBObject docCat= new BasicDBObject("_id", t.getId());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionProduit.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objPro = objCur.next();
        
        //System.out.println("objcat"+objCat);
        
            Pro.setId((int)objPro.get("_id"));
            Pro.setDescription(objPro.get("description").toString());
            Pro.setPrix((int)objPro.get("prix"));
            Pro.setSTOCK((int)objPro.get("STOCK"));
            Pro.setImage(objPro.get("image").toString());
            DBObject objCat =(DBObject) objPro.get("categorie");
            Pro.setIdCatA(new Categorie((int)objCat.get("idcat"),
                    objCat.get("libelle").toString()));  
        
        return Pro;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            public void reset(Produit t) {
        BasicDBObject docPro = new BasicDBObject();
        this.collectionProduit.remove(docPro);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public Produit getOne2(Produit t) {
                Produit Pro =new Produit();
        
        BasicDBObject docCat= new BasicDBObject("description", t.getDescription());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionProduit.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objPro = objCur.next();
        
        //System.out.println("objcat"+objCat);
        
            Pro.setId((int)objPro.get("_id"));
            Pro.setDescription(objPro.get("description").toString());
            Pro.setPrix((int)objPro.get("prix"));
            Pro.setSTOCK((int)objPro.get("STOCK"));
            Pro.setImage(objPro.get("image").toString());
            DBObject objCat =(DBObject) objPro.get("categorie");
            Pro.setIdCatA(new Categorie((int)objCat.get("idcat"),
                    objCat.get("libelle").toString()));  
        
        return Pro;
    
}

    @Override
    public String toString() {
        return "ProduitDao{" + "db=" + db + ", collectionProduit=" + collectionProduit + '}';
    }
        
}
