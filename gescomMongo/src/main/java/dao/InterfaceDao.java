/*publ
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author ZX
 */
public interface InterfaceDao<T>{

    
    public void insert(T t);    
    public void update(T t);
    public void delette(T t);
    public List<T> getALL();
    public T getOne(T t);
       
}
