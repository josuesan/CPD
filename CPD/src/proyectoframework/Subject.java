/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

import java.util.ArrayList;

/**
 * Clase interface definida por concreteSubject, contiene un ArrayList de observers y métodos para agregar o quitar de
 * de la estructura observer.
 * @author Ricky
 */
public interface Subject {
    ArrayList<ConcreteSubject> observers = new ArrayList<ConcreteSubject>();
    
    public void Attach(Usuario u);
    public void Detach(Usuario u);
    public void ActualizarCartelera();
}
