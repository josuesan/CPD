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
public class TipoAdministrador implements TipoUsuario {
    /**
     * Crea una instancia del usuario GerenteResponsable.
     * @return 
     */
    @Override
    public Usuario createUsuario() {
        return new Administrador();
    }
}
