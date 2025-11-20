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
    private Integer idPlan;
    private Integer idViaje;

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

    /**
     * @return the idViaje
     */
    public Integer getIdViaje() {
        return idViaje;
    }

    /**
     * @param idViaje the idViaje to set
     */
    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }
    
}
