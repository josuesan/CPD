/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 * Clase interface instanciada por sus hijos "Tipo"+Usuario, para crear la instancia de los mismos.
 * @author Ricky
 */
public interface TipoUsuario {  
    public Usuario createUsuario();
}
