/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author lg
 */
public class HelperStage {

    public static int getY() {
        int y;
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        y = (int) d.getHeight();
        return y;
    }

    public static int getX() {
        int x;
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        x = (int) d.getWidth();
        return x;
    }

}
