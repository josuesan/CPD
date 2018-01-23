/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 * Clase interface usada por cada usuario. Se implementó Factory Method.
 * @author Ricky
 */
public interface Usuario {     
    public void Update();
    public boolean RegistrarRequerimiento();
    public String getTipo();
    public String getNombre();
    public void setNombre(String name);
    public void setInterfaz(Principal p);
}
