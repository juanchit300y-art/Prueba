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
public class HotelController extends GeneralController<Hotel> {
    CarroRepository carroData;
    HabitacionRepository habitacionData;
    MunicipioRepository municipioData;
    public HotelController() {
    }
    public HotelController(HotelRepository classData) {
        this.classData= new HotelRepository();
        this.habitacionData= new HabitacionRepository();
        this.carroData= new CarroRepository();
        this.municipioData= new MunicipioRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Carro> carrosHotel= carroData.findCarrosByHotel(id);
        if (!carrosHotel.isEmpty()) {
            return false; 
        }
        List<Habitacion> habitacionesHotel= habitacionData.findHabitacionesByHotelId(id);
        if (!habitacionesHotel.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarHotel(Integer id, String nombre, String correo, Integer municipioId) {
        Hotel hotel = classData.findATById(id);
        if (hotel == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            hotel.setNombre(nombre.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            hotel.setCorreo(correo.trim());
        }
        if (municipioId != null) {
            Municipio municipio = municipioData.findATById(municipioId);
            if (municipio == null) {
                return false;
            }
            hotel.setMunicipioId(municipioId);
        }

        classData.saveT(hotel);
        return true;
    }

    public boolean añadirHotel( String nombre, String correo, Integer municipioId) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }
        Municipio municipio = municipioData.findATById(municipioId);
        if (municipio == null) {
            return false;
        }
        
        Hotel hotel = new Hotel();
        hotel.setNombre(nombre);
        hotel.setCorreo(correo);
        hotel.setMunicipioId(municipioId);
        classData.saveT(hotel);
        return true;
    }
}