/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoframework;

/**
 *
 * @author josue
 */
public class Investigador implements Usuario{
    private String name;
    private String tipo = "GerenteSolicitante";
    private String observerState;
    private ConcreteSubject subject;
    public Principal interfaz;
    
    public Investigador(){
    
    }
    

        @Override
    public void Update() {
        interfaz.UpdateCartelera(); 
    }

    @Override
    public boolean RegistrarRequerimiento() {
       return false;
    }
/**
 * Retorna el tipo de usuario.
 * @return 
 */
    @Override
    public String getTipo() {
        return this.tipo;
    }
    /**
     * Recibe un nombre y cambia el actual (principalmente vacío).
     * @param name1 
     */
    @Override
    public void setNombre(String name1) {
        this.name = name1;
    }
/**
 * Cambia la interfaz del cliente para que el sistema y el observer sepa a cual interfaz actualizar.
 * @param p 
 */
    @Override
    public void setInterfaz(Principal p) {
        this.interfaz = p;
    }
    /**
     * Retorna el nombre del usuario.
     * @return 
     */
    @Override
    public String getNombre() {
       return this.name;
    }
}
