/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.docs;

import Main.IDocumento;

/**
 *
 * @author lg
 */
public class Latex implements IDocumento{

    @Override
    public String getOutput() {
        return "Chegou latex";
    }
    
}
