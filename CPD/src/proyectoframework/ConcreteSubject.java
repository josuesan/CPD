/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import java.util.ArrayList;

/**
 * ConcreteSubject implements Subject, hijo de Subject implementa y define los metodos del patrón Observer.
 * @author Ricky
 */
public class ConcreteSubject implements Subject{
    public static ConcreteSubject uniqueSistema;
    private String observerState;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 
    int current = -1;
    
    private ConcreteSubject(){}
    /**
     * Inrecementa en 1 el puntero de la lista de usuarios
     */
    public void setCurrent(){
        this.current = current++;
    }
    /**
     * Retorna el elemento actual.
     * @return int 
     */
    public int getCurrent(){
        return this.current;
    }
    /**
     * Singleton
     * @return ConcreteSubject 
     */
    public static ConcreteSubject Instance(){
        if ( uniqueSistema==null )
            uniqueSistema = new ConcreteSubject();
        return uniqueSistema;
    }
/**
 * Retorna el array de usuarios actuales.
 * @return  
 */
    public ArrayList<Usuario> getArray(){
        return this.usuarios;
    }
    /**
     * Agrega el usuario al patrón.
     * @param u 
     */
    @Override
    public void Attach(Usuario u) {
        usuarios.add(u);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * Actualiza la cartelera a todos los usuarios ayudandose del método Update de cada usuario.
 */
    @Override
    public void ActualizarCartelera() {
       // CarteleraDeRequerimientos cartelera = CarteleraDeRequerimientos.Instance();
        for(int i=0;i<usuarios.size();i++)
            usuarios.get(i).Update();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Obtiene el estado del observer.
     * @return 
     */
    public String GetState(){
        return this.observerState;
    }

    @Override
    public void Detach(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
