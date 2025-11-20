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
public class Trayecto {
    private Integer id;
    private Integer municipioInicio;
    private Integer municipioDestino;

    public Trayecto() {
    }

    public Trayecto(Integer id) {
        this.id = id;
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
     * @return the municipioInicio
     */
    public Integer getMunicipioInicio() {
        return municipioInicio;
    }

    /**
     * @param municipioInicio the municipioInicio to set
     */
    public void setMunicipioInicio(Integer municipioInicio) {
        this.municipioInicio = municipioInicio;
    }

    /**
     * @return the municipioDestino
     */
    public Integer getMunicipioDestino() {
        return municipioDestino;
    }

    /**
     * @param municipioDestino the municipioDestino to set
     */
    public void setMunicipioDestino(Integer municipioDestino) {
        this.municipioDestino = municipioDestino;
    }
    
    
}
