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
        Guia guia = classData.findATById(id);
        if (guia == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            guia.setNombre(nombre.trim());
        }
        if (contraseña != null && !contraseña.trim().isEmpty()) {
            guia.setContraseña(contraseña.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            guia.setCorreo(correo.trim());
        }
        if (añosExperiencia != null && añosExperiencia > -1) {
            guia.setAñosExperiencia(añosExperiencia);
        }      

        classData.saveT(guia);
        return true;
    }

    public boolean añadirGuia(String nombre, String contraseña,String correo,  Integer añosExperiencia) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (contraseña == null ||  contraseña.trim().isEmpty()) {
            return false;
        }
        if (correo == null  || correo.trim().isEmpty()) {
            return false;
        }
        if (añosExperiencia == null  || añosExperiencia<0) {
            return false;
        }  
        Guia guia = new Guia();
        guia.setNombre(nombre.trim());
        guia.setContraseña(contraseña);
        guia.setCorreo(correo);
        guia.setAñosExperiencia(añosExperiencia);
        
        classData.saveT(guia);
        return true;
    }
}