/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import java.util.ArrayList;

// SINGLETON
public class CarteleraDeRequerimientos implements Cartelera{
    
    private static CarteleraDeRequerimientos uniqueCartelera;
    private ArrayList<Requerimiento> listaRequerimiento;
    
    
    /**   
    * Constructor de la clase CarteleraDeRequerimientos
    */
    private CarteleraDeRequerimientos(){
       listaRequerimiento= new ArrayList<Requerimiento>();
    }
    
     /**
     * Retorna una unica instancia de la cartelera de requerimientos.
     * @return CarteleraDeRequerimientos uniqueCartelera;
     */
    public static CarteleraDeRequerimientos Instance(){        
        if(uniqueCartelera == null)             
            uniqueCartelera = new CarteleraDeRequerimientos();          
        return uniqueCartelera;
    }      
    
    /**
     * Retorna la lista de requerimientos
     * @return uniqueCartelera.listaRequerimiento;
     */
    public ArrayList<Requerimiento> getCarteleraDeRequerimientos(){
        return uniqueCartelera.listaRequerimiento;
    }
    /**
     * Agrega un requerimiento a la cartelera unica
     * @param Requerimiento nuevoRequerimiento  
    */    
    public void addRequerimiento(Requerimiento nuevoRequerimiento){
        uniqueCartelera.listaRequerimiento.add(nuevoRequerimiento);
    }
    /**
     * Elimina la cartelera y la inicializa con un nuevo ArrayList<Requerimiento>.
     */
    public void RemoveArray(){        
        listaRequerimiento = new ArrayList<Requerimiento>();        
    }
    
    
     /**
     * Retorna un nuevo iterador para la cartelera de requerimientos.
     * @return Iterator new CarteleraIterator(this);
     */
    @Override
    public Iterator createIterator() {
        return (Iterator) new CarteleraIterator(this);
    }   
}
