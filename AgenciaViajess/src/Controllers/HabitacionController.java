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
public class HabitacionController extends GeneralController<Habitacion> {
    ReservaRepository reservaData;
    HotelRepository hotelData;
    public HabitacionController() {
    }
    public HabitacionController(HabitacionRepository classData) {
        this.classData= new HabitacionRepository();
        this.reservaData= new ReservaRepository();
        this.hotelData= new HotelRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Reserva> reservasHabitacion= reservaData.findReservaByHabitacionId(id);
        if (!reservasHabitacion.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarHabitacion(Integer id, Integer capacidad, Integer hotelId) {
        Habitacion habitacion = classData.findATById(id);
        if (habitacion == null) {
            return false;
        }
        if (capacidad != null && capacidad >0) {
            habitacion.setCapacidad(capacidad);
        }
        if (hotelId != null) {
            Hotel hotel = hotelData.findATById(hotelId);
            if (hotel == null) {
                return false;
            }
            habitacion.setHotelId(hotelId);
        }

        classData.saveT(habitacion);
        return true;
    }

    public boolean añadirHabitacion( Integer capacidad, Integer hotelId) {
        if (capacidad == null || capacidad>=0 ) {
            return false;
        }
        Hotel hotel = hotelData.findATById(hotelId);
        if (hotel == null) {
            return false;
        }
        
        Habitacion habitacion = new Habitacion();
        habitacion.setCapacidad(capacidad);
        habitacion.setHotelId(hotelId);
        classData.saveT(habitacion);
        return true;
    }
}

//Turno relacion (caso profesor)
    public List<Reserva> getReservasDeHabitacion(Integer habitacionId){ 
        return reservaData.findTurnosByGuiaId(guiaId);
    }
    public boolean assignTurnoToGuia(Integer guiaId, Integer turnoId) {
        Guia guia = classData.findATById(guiaId);
        Turno turno = turnoData.findATById(turnoId);
        
        if (guia == null || turno == null) {
            return false;
        }
        
        turno.setGuiaId(guiaId);
        turnoData.saveT(turno);
        return true;
    }
}