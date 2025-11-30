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
public abstract class Vehiculo {
    private Integer id;
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String marca) {
        this.id = id;
        this.marca = marca;
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "=== Datos de Vehículo ===" +
               "ID: " + id + "\n" +
               "Marca: " + marca + "\n";
    }   
}
