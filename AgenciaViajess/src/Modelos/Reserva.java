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
public class Reserva {
    private Integer id;
    private int numPersonas;
    private Integer idHabitacion;
    private Integer idItinerarioTransporte;

    public Reserva() {
    }

    public Reserva(Integer id, int numPersonas) {
        this.id = id;
        this.numPersonas = numPersonas;
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
     * @return the numPersonas
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * @param numPersonas the numPersonas to set
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * @return the idHabitacion
     */
    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * @param idHabitacion the idHabitacion to set
     */
    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * @return the idItinerarioTransporte
     */
    public Integer getIdItinerarioTransporte() {
        return idItinerarioTransporte;
    }

    /**
     * @param idItinerarioTransporte the idItinerarioTransporte to set
     */
    public void setIdItinerarioTransporte(Integer idItinerarioTransporte) {
        this.idItinerarioTransporte = idItinerarioTransporte;
    }
    
}
