/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Modelos.Reserva;

public class ReservaRepository extends GeneralRepository<Reserva>{
    
    
    public ReservaRepository() {
        this.dataAccess = new JsonRepository<>("Reservas.json", Reserva.class);
    }
    public ReservaRepository(IDataAccess<Reserva> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<Reserva> findReservaByItinerarioTransporteId(Integer itinerarioTransporteId) {
        List<Reserva> reservas = getAllT();
        List<Reserva> result = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getItinerarioTransporteId() != null && reserva.getItinerarioTransporteId().equals(itinerarioTransporteId)) {
                result.add(reserva);
            }
        }
        return result;
    }
    public List<Reserva> findReservaByHabitacionId(Integer habitacionId) {
        List<Reserva> reservas = getAllT();
        List<Reserva> result = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacionId() != null && reserva.getHabitacionId().equals(habitacionId)) {
                result.add(reserva);
            }
        }
        return result;
    }
}