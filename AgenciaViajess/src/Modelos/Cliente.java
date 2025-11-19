/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Juan Guerrero
 */
public class Cliente extends Usuario{
    private String medioDePago;

    public Cliente() {
    }

    public Cliente(String medioDePago, Integer id, String nombre, String contraseña, String correo) {
        super(id, nombre, contraseña, correo);
        this.medioDePago = medioDePago;
    }

    /**
     * @return the medioDePago
     */
    public String getMedioDePago() {
        return medioDePago;
    }

    /**
     * @param medioDePago the medioDePago to set
     */
    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }
    
}
