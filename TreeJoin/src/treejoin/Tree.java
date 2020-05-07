/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treejoin;

/**
 *
 * @author Alfredo Maldonado
 */
public interface Tree<T> {
    
    public void insert(T value);
    
    public int getLevel();
    
    public boolean isEmpty();
}
