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
    private Integer costo;
    private Integer ViajeId;
    private Integer ClienteId;
    
    
    public Factura() {
    }
    
    public Factura(Integer id, Integer costo) {
        this.id = id;
        this.costo= costo;
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
     * @return the ClienteId
     */
    public Integer getClienteId() {
        return ClienteId;
    }

    /**
     * @param ClienteId the ClienteId to set
     */
    public void setClienteId(Integer ClienteId) {
        this.ClienteId = ClienteId;
    }

    /**
     * @return the costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }



   

}
