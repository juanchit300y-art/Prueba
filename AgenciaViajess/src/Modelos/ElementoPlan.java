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
    private Integer ActividadTuristicaId;
    private Integer PlanId;
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
    public Integer getActividadTuristicaId() {
        return ActividadTuristicaId;
    }

    /**
     * @param idActividadTuristica the idActividadTuristica to set
     */
    public void setActividadTuristicaId(Integer idActividadTuristica) {
        this.ActividadTuristicaId = idActividadTuristica;
    }

    /**
     * @return the idPlan
     */
    public Integer getPlanId() {
        return PlanId;
    }

    /**
     * @param idPlan the idPlan to set
     */
    public void setPlanId(Integer idPlan) {
        this.PlanId = idPlan;
    }
    @Override
    public String toString() {
    return "=== Datos de Elemento del Plan ===\n" +
           "ID: " + id + "\n" +
           "ID Actividad Turística: " + ActividadTuristicaId + "\n" +
           "ID Plan: " + PlanId + "\n";
    }
    
}
