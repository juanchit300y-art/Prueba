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
public class ActividadTuristica {
   private Integer id;
   private String nombre;
   private Integer MunicipioId;

    public ActividadTuristica() {
    }

    public ActividadTuristica(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idMunicipio
     */
    public Integer getMunicipioId() {
        return MunicipioId;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setMunicipioId(Integer idMunicipio) {
        this.MunicipioId = idMunicipio;
    }
   @Override
    public String toString() {
    return "=== Datos de Actividad Turística ===\n" +
           "ID: " + id + "\n" +
           "Nombre: " + nombre + "\n" +
           "ID Municipio: " + MunicipioId + "\n";
    }

}
