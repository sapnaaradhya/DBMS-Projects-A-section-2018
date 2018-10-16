/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.SQLException;
import lgform.LGForm;
/**
 *
 * @author Suma
 */
public class Testing {//everything is proper
    
    
    public static void main(String[] args) throws SQLException{
        
        LGForm lg = new LGForm();
        System.out.println(lg);
        System.out.println(lg.createTableStudent());
    
    }
}
