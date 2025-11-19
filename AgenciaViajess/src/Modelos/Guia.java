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
    private int añosExperiencia;

    public Guia() {
    }

    public Guia(int añosExperiencia, Integer id, String nombre, String contraseña, String correo) {
        super(id, nombre, contraseña, correo);
        this.añosExperiencia = añosExperiencia;
    }

    /**
     * @return the añosExperiencia
     */
    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    /**
     * @param añosExperiencia the añosExperiencia to set
     */
    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
    
}
