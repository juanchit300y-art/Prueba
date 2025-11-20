/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;
//uwu
/**
 *
 * @author Juan Guerrero
 */
public class Carro extends Vehiculo {
    private Integer HotelId;
    
    public Carro() {
    }
    public Carro( int id, String marca) {
    super(id, marca);
    }

    /**
     * @return the idHotel
     */
    public Integer getHotelId() {
        return HotelId;
    }

    /**
     * @param idHotel the idHotel to set
     */
    public void setHotelId(Integer idHotel) {
        this.HotelId = idHotel;
    }
}
