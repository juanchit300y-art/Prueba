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
public class ItinerarioTransporte {
    private Integer id;
    private Integer orden;
    private Integer TrayectoId;
    private Integer ViajeId;

    public ItinerarioTransporte() {
    }

    public ItinerarioTransporte(Integer id, Integer orden) {
        this.id = id;
        this.orden = orden;
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
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    /**
     * @return the TrayectoId
     */
    public Integer getTrayectoId() {
        return TrayectoId;
    }

    /**
     * @param TrayectoId the TrayectoId to set
     */
    public void setTrayectoId(Integer TrayectoId) {
        this.TrayectoId = TrayectoId;
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
    @Override
    public String toString() {
        return "=== Datos de Itinerario de Transporte === " +
               "ID: " + id + " " +
               "Orden: " + orden + " " +
               "ID Trayecto: " + TrayectoId + " " +
               "ID Viaje: " + ViajeId;
    }

}
