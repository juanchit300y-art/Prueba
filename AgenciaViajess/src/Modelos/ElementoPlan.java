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
public class ElementoPlan {
    private Integer id;
    private Integer idActividadTuristica;
    private Integer idPlan;
    public ElementoPlan() {
    }

    public ElementoPlan(Integer id) {
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
     * @return the idPlan
     */
    public Integer getIdPlan() {
        return idPlan;
    }

    /**
     * @param idPlan the idPlan to set
     */
    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }
    
}
