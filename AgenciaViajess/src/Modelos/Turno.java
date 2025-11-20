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
public class Turno {
    private Integer id;
    private Integer ActividadTuristicaId;
    private Integer GuiaId;

    public Turno() {
    }

    public Turno(Integer id) {
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
     * @return the ActividadTuristicaId
     */
    public Integer getActividadTuristicaId() {
        return ActividadTuristicaId;
    }

    /**
     * @param ActividadTuristicaId the ActividadTuristicaId to set
     */
    public void setActividadTuristicaId(Integer ActividadTuristicaId) {
        this.ActividadTuristicaId = ActividadTuristicaId;
    }

    /**
     * @return the GuiaId
     */
    public Integer getGuiaId() {
        return GuiaId;
    }

    /**
     * @param GuiaId the GuiaId to set
     */
    public void setGuiaId(Integer GuiaId) {
        this.GuiaId = GuiaId;
    }

    
}
