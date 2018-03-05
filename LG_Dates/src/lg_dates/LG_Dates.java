/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lg_dates;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author lg
 */
public class LG_Dates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);
        agora = agora.plusYears(100);
        System.out.println(agora);
        agora = agora.withYear(100);
        System.out.println(agora);
        LocalDate agora2 = LocalDate.now();
        
         
        
        
        
        
    }
    
}
