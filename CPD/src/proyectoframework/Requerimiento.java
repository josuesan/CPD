/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import java.util.ArrayList;

/**
 *
 * @author Ricky
 */

public class Requerimiento {
    private ArrayList<String> data;
    
    /** Instancia un requerimiento completo, con todos sus atributos;
     * @param data, fechaInicio, fechaFin
     * */
    public Requerimiento(ArrayList<String> data){
        this.data = data;
    }
    /**
     * Obtiene el dato en la lista de elementos que posee el Requerimiento.
     * @param index
     * @return 
     */
    public String get (int index){  
        return this.data.get(index);
    }
    /**
     * Cambia los valores de un requerimiento, específicamente un elemento de este.
     * @param index
     * @param value
     * @return 
     */
    public String set (int index, String value){
        return this.data.set(index, value);
    }
}
