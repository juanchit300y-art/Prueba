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
    private Integer municipioInicioId;
    private Integer municipioDestinoId;

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
    public Integer getMunicipioInicioId() {
        return municipioInicioId;
    }

    /**
     * @param municipioInicio the municipioInicio to set
     */
    public void setMunicipioInicioId(Integer municipioInicio) {
        this.municipioInicioId = municipioInicio;
    }

    /**
     * @return the municipioDestino
     */
    public Integer getMunicipioDestinoId() {
        return municipioDestinoId;
    }

    /**
     * @param municipioDestino the municipioDestino to set
     */
    public void setMunicipioDestinoId(Integer municipioDestino) {
        this.municipioDestinoId = municipioDestino;
    }
    @Override
    public String toString() {
        return "=== Datos de Trayecto ===\n" +
               "ID: " + id + "\n" +
               "ID Municipio Inicio: " + municipioInicioId + "\n" +
               "ID Municipio Destino: " + municipioDestinoId+ "\n";
    }
}
