/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 * CarteleraIterator implements Iterator, se usa para recorrer la cartelera con el patrón de diseño Iterator.
 * 
 * @author Ricky
 */
public class CarteleraIterator implements Iterator{
    
    private CarteleraDeRequerimientos cartelera;
    private int currentItem;
    /**
     * Constructor de la clase Cartelera Iterator
     * @param cartelera 
     */
    CarteleraIterator(CarteleraDeRequerimientos cartelera) {
        this.cartelera = cartelera;
        this.currentItem = 0;
    }
/**
 * Retorna el primer elemento de la lista.
 * @return Primer elemento de la lista - Tipo Requerimiento 
 */
    @Override
    public Requerimiento First() {
        return cartelera.getCarteleraDeRequerimientos().get(0);
    }
/**
 * Retorna el siguiente elemento de la lista.
 * @return Requerimiento siguiente al actual 
 */
    @Override
    public Requerimiento Next() { 
        if(this.currentItem < cartelera.getCarteleraDeRequerimientos().size())
            return cartelera.getCarteleraDeRequerimientos().get(this.currentItem++);
        else
            return null;
    }
/**
 * 
 * @return boolean | Define si ya está en el final de la lista | 
 */
    @Override
    public boolean IsDone() {
       // return false;
        return this.currentItem >= cartelera.getCarteleraDeRequerimientos().size();
    }
/**
 * Retorna el elemento actual en el que el puntero de la lista está.
 * @return Requerimiento
 */
    @Override
    public Requerimiento CurrentItem(){
        return cartelera.getCarteleraDeRequerimientos().get(this.currentItem);
    }
    
}
