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
public class Cuota {
    private Integer id;
    private Integer monto;
    private Integer viajeId;

    public Cuota() {
    }
//nn
    public Cuota(Integer id, Integer monto) {
        this.id = id;
        this.monto = monto;
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
     * @return the monto
     */
    public Integer getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    /**
     * @return the idViaje
     */
    public Integer getViajeId() {
        return viajeId;
    }

    /**
     * @param idViaje the idViaje to set
     */
    public void setViajeId(Integer idViaje) {
        this.viajeId = idViaje;
    }
    @Override
    public String toString() {
    return "=== Datos de Cuota ===\n" +
           "ID: " + id + "\n" +
           "Monto: " + monto + "\n" +
           "ID Viaje: " + viajeId + "\n";
    }

    
}
