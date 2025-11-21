
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class HabitacionRepository extends GeneralRepository<Habitacion> {
    
    public HabitacionRepository() {
        this.dataAccess = new JsonRepository<>("habitaciones.json", Habitacion.class);
    }
    public HabitacionRepository(IDataAccess<Habitacion> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<Habitacion> findHabitacionesByHotelId(Integer planId) {
        List<Habitacion> habitaciones = getAllT();
        List<Habitacion> result = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getHotelId() != null && habitacion.getHotelId().equals(planId)) {
                result.add(habitacion);
            }
        }
        return result;
    }
}