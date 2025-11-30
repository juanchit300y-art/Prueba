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
public class Viaje {
   private Integer id;

    public Viaje() {
    }

    public Viaje(Integer id) {
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
    @Override
    public String toString() {
        return "=== Datos de Viaje ===\n " +
               "ID: " + id + "\n";
    }
}
