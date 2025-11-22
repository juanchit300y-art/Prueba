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
public class ServicioTransporte {
    private Integer id;
    private String fecha_inicio;
    private String fecha_fin;
    private Double costo;
    //relaciones
    private Integer VehiculoId;
    private Integer TrayectoId;

    public ServicioTransporte() {
    }

    public ServicioTransporte(Integer id, String fecha_inicio, String fecha_fin, Double costo) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.costo = costo;
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
     * @return the fecha_iniciio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio= fecha_inicio;
    }

    /**
     * @return the fecha_fin
     */
    public String getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the costo
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * @return the VehiculoId
     */
    public Integer getVehiculoId() {
        return VehiculoId;
    }

    /**
     * @param VehiculoId the VehiculoId to set
     */
    public void setVehiculoId(Integer VehiculoId) {
        this.VehiculoId = VehiculoId;
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


    
}
