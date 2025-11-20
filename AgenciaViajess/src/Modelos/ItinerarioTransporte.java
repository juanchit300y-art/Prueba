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
    private int orden;
    private Integer idTrayecto;
    private Integer idViaje;

    public ItinerarioTransporte() {
    }

    public ItinerarioTransporte(Integer id, int orden) {
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
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
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

    /**
     * @return the idViaje
     */
    public Integer getIdViaje() {
        return idViaje;
    }

    /**
     * @param idViaje the idViaje to set
     */
    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }
    
}
