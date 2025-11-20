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
public class Carro extends Vehiculo {
    private Integer idHotel;
    
    public Carro() {
    }
    public Carro( int id, String marca) {
    super(id, marca);
    }

    /**
     * @return the idHotel
     */
    public Integer getIdHotel() {
        return idHotel;
    }

    /**
     * @param idHotel the idHotel to set
     */
    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }
}
