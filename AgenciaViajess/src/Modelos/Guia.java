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
public class Guia extends Usuario {
    private Integer añosExperiencia;

    public Guia() {
    }

    public Guia( Integer id, String nombre, String contraseña, String correo, Integer añosExperiencia) {
        super(id, nombre, contraseña, correo);
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * @return the añosExperiencia
     */
    public Integer getAñosExperiencia() {
        return añosExperiencia;
    }

    /**
     * @param añosExperiencia the añosExperiencia to set
     */
    public void setAñosExperiencia(Integer añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
    
}
