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
public class Hotel {
    private Integer id;
    private String nombre;
    private String correo;
    private Integer MunicipioId;
    

    public Hotel() {
    }

    public Hotel(Integer id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the MunicipioId
     */
    public Integer getMunicipioId() {
        return MunicipioId;
    }

    /**
     * @param MunicipioId the MunicipioId to set
     */
    public void setMunicipioId(Integer MunicipioId) {
        this.MunicipioId = MunicipioId;
    }
@Override
public String toString() {
    return "=== Datos de Hotel ===\n" +
           "ID: " + id + "\n"
           + "Nombre: " + nombre + "\n" +
           "Correo: " + correo + "\n"+
           "ID Municipio: " + MunicipioId + "\n";
}

}
