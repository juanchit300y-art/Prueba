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
    private String fecha_iniciio;
    private String fecha_fin;
    private Double costo;
    //relaciones
    private Integer idVehiculo;
    private Integer idTrayecto;

    public ServicioTransporte() {
    }

    public ServicioTransporte(Integer id, String fecha_iniciio, String fecha_fin, Double costo) {
        this.id = id;
        this.fecha_iniciio = fecha_iniciio;
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
    public String getFecha_iniciio() {
        return fecha_iniciio;
    }

    /**
     * @param fecha_iniciio the fecha_iniciio to set
     */
    public void setFecha_iniciio(String fecha_iniciio) {
        this.fecha_iniciio = fecha_iniciio;
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
     * @return the idVehiculo
     */
    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * @param idVehiculo the idVehiculo to set
     */
    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    /**
     * @return the idTrayecto
     */
    public Integer getIdTrayecto() {
        return idTrayecto;
    }

    /**
     * @param idTrayecto the idTrayecto to set
     */
    public void setIdTrayecto(Integer idTrayecto) {
        this.idTrayecto = idTrayecto;
    }
    
}
