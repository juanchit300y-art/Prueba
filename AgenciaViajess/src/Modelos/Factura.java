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
public class Factura {
    private Integer id;
    private Integer ViajeId;
    private Integer UsuarioId;
    
    
    public Factura() {
    }
    
    public Factura(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the ViajeId
     */
    public Integer getViajeId() {
        return ViajeId;
    }

    /**
     * @param ViajeId the ViajeId to set
     */
    public void setViajeId(Integer ViajeId) {
        this.ViajeId = ViajeId;
    }

    /**
     * @return the UsuarioId
     */
    public Integer getUsuarioId() {
        return UsuarioId;
    }

    /**
     * @param UsuarioId the UsuarioId to set
     */
    public void setUsuarioId(Integer UsuarioId) {
        this.UsuarioId = UsuarioId;
    }

   

}
