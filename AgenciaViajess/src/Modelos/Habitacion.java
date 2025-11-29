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
public class Habitacion {
    private Integer Id;
    private Integer capacidad;
    private Integer HotelId;
    public Habitacion() {
    }

    public Habitacion(Integer Id, Integer capacidad) {
        this.Id = Id;
        this.capacidad = capacidad;
    }

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the capacidad
     */
    public Integer getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the HotelId
     */
    public Integer getHotelId() {
        return HotelId;
    }

    /**
     * @param HotelId the HotelId to set
     */
    public void setHotelId(Integer HotelId) {
        this.HotelId = HotelId;
    }
    @Override
    public String toString() {
        return "=== Datos de Habitación ===\n" +
               "ID: " + Id + "\n" +
               "Capacidad: " + capacidad + "\n" +
               "ID Hotel: " + HotelId;
    }


}
