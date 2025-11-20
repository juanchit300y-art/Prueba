
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Habitacion;

public class HabitacionRepository extends GeneralRepository<Habitacion> {
    
    public HabitacionRepository() {
        this.dataAccess = new JsonRepository<>("habitaciones.json", Habitacion.class);
    }
    public HabitacionRepository(IDataAccess<Habitacion> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}