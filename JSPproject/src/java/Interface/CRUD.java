/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.List;

/**
 *
 * @author Alfredo Maldonado
 * @param <T>
 */
public interface CRUD<T> {
    
    public List listAll();
    
    public T listById(int id);
    
    public boolean add(T person);
    
    public boolean edit(T person);
    
    public boolean delete(int id);
    
    public List findByValue(String value);
}
