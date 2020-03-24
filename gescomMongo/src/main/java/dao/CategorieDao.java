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

/**
 *
 * @author ZX
 */
public class CategorieDao implements InterfaceDao<Categorie>{
    
    
    private DB db;
    private DBCollection collectionCategorie; 
    
    
    public CategorieDao(){
        this.db=ConecMongo.getDb();
        this.collectionCategorie=this.db.getCollection("categorie");
        
        
    }

    @Override
    public void insert(Categorie t) {
        BasicDBObject docCat = new BasicDBObject();
        docCat.append("_id", t.getIdcat()).append("libelle", t.getLibelle());
        this.collectionCategorie.insert(docCat);
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Categorie t) {
        BasicDBObject docCatOld = new BasicDBObject();
        docCatOld.append("_id", t.getIdcat());
        BasicDBObject docCatnew = new BasicDBObject();
        docCatnew.append("_id", t.getIdcat()).append("libelle", t.getLibelle());
        this.collectionCategorie.update(docCatOld, docCatnew);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delette(Categorie t) {
        BasicDBObject docCat = new BasicDBObject();
        docCat.append("_id", t.getIdcat());
        this.collectionCategorie.remove(docCat);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public void reset(Categorie t) {
        BasicDBObject docCat = new BasicDBObject();
        this.collectionCategorie.remove(docCat);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie> getALL() {
        List<Categorie> listeCat= new ArrayList<>();
        DBCursor cursor = this.collectionCategorie.find();
        while(cursor.hasNext()){
            DBObject objcat = cursor.next();
            Categorie cat = new Categorie();
            cat.setIdcat((int)objcat.get("_id"));
            cat.setLibelle(objcat.get("libelle").toString());
            listeCat.add(cat);
        }
                
        return listeCat;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CategorieDao{" + "db=" + db + ", collectionCategorie=" + collectionCategorie + '}';
    }

    @Override
    public Categorie getOne(Categorie t) {
        Categorie cat=new Categorie();
        
        BasicDBObject docCat= new BasicDBObject("_id", t.getIdcat());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionCategorie.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objCat = objCur.next();
        
        //System.out.println("objcat"+objCat);
        
        cat.setIdcat((int)objCat.get("_id"));
        cat.setLibelle(objCat.get("libelle").toString());
        
        return cat;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public Categorie getCat2(Categorie t){
       Categorie cat=new Categorie();
        
        BasicDBObject docCat= new BasicDBObject("libelle", t.getLibelle());
        //System.out.println(docCat);
        
        DBCursor objCur = this.collectionCategorie.find(docCat);
        //System.out.println("objcur="+objCur);
        DBObject objCat = objCur.next();
        
        //System.out.println("objcat"+objCat);
        
        cat.setIdcat((int)objCat.get("_id"));
        cat.setLibelle(objCat.get("libelle").toString());
        
        return cat;
    
}
}
