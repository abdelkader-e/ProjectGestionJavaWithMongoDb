/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import com.mongodb.DB;
import com.mongodb.MongoClient;



/**
 *
 * @author ZX
 */
public class ConecMongo {
    static DB db;
    
    /*static {
        try{
            MongoClient mngClient = new MongoClient("localhost",27017);
            
            System.out.print(mngClient.getDatabaseNames());
            db=mngClient.getDB("gescom");
                   
                    
        }
        catch(Exception e){
                System.out.print(e.getMessage());
        }
           
    }*/

    public static DB getDb() {
         
         try{MongoClient mngClient = new MongoClient("localhost",27017);
            
            //System.out.print(mngClient.getDatabaseNames());
            db=mngClient.getDB("gescom");
            //System.out.print(db.getName());
                  }
        catch(Exception e){
                System.out.print(e.getMessage());
        }
        return db;
    }
    
    
 
}
