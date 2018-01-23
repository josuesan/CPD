/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 * Iterator clase interfaz definida por sus hijos, contiene los métodos necesarios para recorrer una lista o cualquier tipo de estructura de datos.
 * @author Ricky
 */
public interface Iterator {
    public Requerimiento First();
    public Requerimiento Next();
    public boolean IsDone();
    public Requerimiento CurrentItem();
}
