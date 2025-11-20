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
public class Aeronave extends Vehiculo{
    private Integer idAerolinea;
    public Aeronave() {
    }
    public Aeronave( int id, String marca) {
    super(id, marca);
    }

    /**
     * @return the idAerolinea
     */
    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    /**
     * @param idAerolinea the idAerolinea to set
     */
    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
}
