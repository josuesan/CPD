/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// CLIENTE PROYECTOFRAMEWORK
package proyectoframework;

import java.sql.SQLException;

/**
 *
 * @author Ricky
 */
public class ProyectoFramework {  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {   
        Conexion C = new Conexion();
        C.obtener();
        Inicio i = new Inicio();
        Inicio i2 = new Inicio();
        i.setNumero(0);
        i2.setNumero(1);
    }
}
