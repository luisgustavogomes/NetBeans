/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torrehanoi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Gustavo
 */
public class Pilha {

    
    private List<Integer> valores = new ArrayList<>(4);

      

    public int getTamanho() {
        return this.valores.size();
    }
        
    public boolean push (int i){
        valores.add(i);
        return true;
    }
    
    public int pop (){
        try{
            return valores.remove(valores.size()-1);
        } catch (Exception ex){
            return -1;
        }
    }
    
     public int top (){
        try{
            return valores.get(valores.size()-1);
        } catch (Exception ex){
            return 5;
        }
    }

    
    
}
