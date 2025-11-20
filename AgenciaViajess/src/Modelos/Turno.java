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
    private Integer idActividadTuristica;
    private Integer idGuia;

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
     * @return the idActividadTuristica
     */
    public Integer getIdActividadTuristica() {
        return idActividadTuristica;
    }

    /**
     * @param idActividadTuristica the idActividadTuristica to set
     */
    public void setIdActividadTuristica(Integer idActividadTuristica) {
        this.idActividadTuristica = idActividadTuristica;
    }

    /**
     * @return the idGuia
     */
    public Integer getIdGuia() {
        return idGuia;
    }

    /**
     * @param idGuia the idGuia to set
     */
    public void setIdGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }
    //uwu
}
