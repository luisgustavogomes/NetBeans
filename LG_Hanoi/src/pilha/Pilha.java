/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizfduartejr
 */
public class Pilha<T> {

    private List<T> valores = new ArrayList<>();
    
    public int getSize(){
        return valores.size();
    }
    
    public boolean push(T v){
        valores.add(v);
        return true;
    }
    
    public T pop(){
        try{
            return valores.remove(valores.size()-1);
        }
        catch(Exception ex){
            return null;
        }
    }
    
    public T top(){
        try{
            return valores.get(valores.size() - 1);
        }
        catch(Exception ex){
            return null;
        }
    }
}
