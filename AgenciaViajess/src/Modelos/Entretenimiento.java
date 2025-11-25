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
public class Entretenimiento {
    private Integer id;
    private Integer PlanId;
    private Integer ViajeId;

    public Entretenimiento() {
    }

    public Entretenimiento(Integer id) {
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
     * @return the PlanId
     */
    public Integer getPlanId() {
        return PlanId;
    }

    /**
     * @param PlanId the PlanId to set
     */
    public void setPlanId(Integer PlanId) {
        this.PlanId = PlanId;
    }

    /**
     * @return the ViajeId
     */
    public Integer getViajeId() {
        return ViajeId;
    }

    /**
     * @param ViajeId the ViajeId to set
     */
    public void setViajeId(Integer ViajeId) {
        this.ViajeId = ViajeId;
    }
    @Override
    public String toString() {
    return "=== Datos de Entretenimiento ===\n" +
           "ID: " + id + "\n" +
           "ID Plan: " + PlanId + "\n" +
           "ID Viaje: " + ViajeId + "\n";
    }


}