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
    private Integer numPersonas;
    private Integer HabitacionId;
    private Integer ItinerarioTransporteId;

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
    public Integer getNumPersonas() {
        return numPersonas;
    }

    /**
     * @param numPersonas the numPersonas to set
     */
    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * @return the HabitacionId
     */
    public Integer getHabitacionId() {
        return HabitacionId;
    }

    /**
     * @param HabitacionId the HabitacionId to set
     */
    public void setHabitacionId(Integer HabitacionId) {
        this.HabitacionId = HabitacionId;
    }

    /**
     * @return the ItinerarioTransporteId
     */
    public Integer getItinerarioTransporteId() {
        return ItinerarioTransporteId;
    }

    /**
     * @param ItinerarioTransporteId the ItinerarioTransporteId to set
     */
    public void setItinerarioTransporteId(Integer ItinerarioTransporteId) {
        this.ItinerarioTransporteId = ItinerarioTransporteId;
    }

    
}
