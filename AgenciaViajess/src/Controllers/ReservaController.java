/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.List;


/**
 *
 * @author DELL
 */
public class ReservaController extends GeneralController<Reserva> {
    HabitacionRepository habitacionData;
    ItinerarioTransporteRepository itinerarioTransporteData;
    
    public ReservaController() {
    }
    public ReservaController(ReservaRepository classData) {
        this.classData= new ReservaRepository();
        this.habitacionData= new HabitacionRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarReserva(Integer id,Integer numPersonas,  Integer habitacionId, Integer itinerarioTransporteId) {
        Reserva reserva = classData.findATById(id);
        if (reserva == null) {
            return false;
        }
        if (numPersonas != null && numPersonas<0) {
            reserva.setNumPersonas(numPersonas);
        }
        if (habitacionId != null) {
            Habitacion habitacion = habitacionData.findATById(habitacionId);
            if (habitacion == null) {
                return false;
            }
            reserva.setHabitacionId(habitacionId);
        }
        if(itinerarioTransporteId!= null){
            ItinerarioTransporte itinerarioTransporte= itinerarioTransporteData.findATById(itinerarioTransporteId);
            if(itinerarioTransporte== null){
                return false;
            }
            reserva.setItinerarioTransporteId(itinerarioTransporteId);
        }        
        classData.saveT(reserva);
        return true;
    }

    public boolean añadirReserva(Integer numPersonas, Integer habitacionId, Integer itinerarioTransporteId) {
        if (numPersonas == null || numPersonas<1) {
            return false;
        }
        
        Habitacion habitacion = habitacionData.findATById(habitacionId);
        if (habitacion == null) {
            return false;
        }
        ItinerarioTransporte itinerarioTransporte = itinerarioTransporteData.findATById(itinerarioTransporteId);
        if (itinerarioTransporte == null) {
            return false;
        }
        Reserva reserva = new Reserva();
        reserva.setNumPersonas(numPersonas);
        reserva.setHabitacionId(habitacionId);
        reserva.setItinerarioTransporteId(itinerarioTransporteId);
        
        classData.saveT(reserva);
        return true;
    }
}