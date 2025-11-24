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
    HotelRepository hotelData;
    
    public HotelController() {
        this.classData= new HotelRepository();
        this.habitacionData= new HabitacionRepository();
        this.carroData= new CarroRepository();
        this.municipioData= new MunicipioRepository();
        this.hotelData = new HotelRepository();
    }
    public HotelController(HotelRepository classData) {
        this.classData= classData;
        this.habitacionData= new HabitacionRepository();
        this.carroData= new CarroRepository();
        this.municipioData= new MunicipioRepository();
        this.hotelData = new HotelRepository();
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
    
    
    
    //Relacion lista Habitaciones (caso profesor)
    public List<Habitacion> getHabitacionesDeHotel(Integer hotelId){ 
        return habitacionData.findHabitacionesByHotelId(hotelId);
    }
    public boolean assignHabitacionToHotel(Integer hotelId, Integer habitacionId) {
        Hotel hotel = classData.findATById(hotelId);
        Habitacion habitacion = habitacionData.findATById(habitacionId);
        
        if (hotel == null || habitacion == null) {
            return false;
        }
        
        habitacion.setHotelId(hotelId);
        habitacionData.saveT(habitacion);
        return true;
    }
    //lista carros (caso profesor)
    public List<Carro> getCarrosDeHotel(Integer hotelId){ 
    return carroData.findCarrosByHotel(hotelId);
    }
    public boolean assignCarroToHotel(Integer hotelId, Integer carroId) {
        Hotel hotel = classData.findATById(hotelId);
        Carro carro = carroData.findATById(carroId);
        
        if (hotel == null || carro == null) {
            return false;
        }
        
        carro.setHotelId(hotelId);
        carroData.saveT(carro);
        return true;
    }
    
    //Relacion a Municipio (caso curso)
    public List<Hotel> getHotelesByMunicipio(Integer municipioId) {
        return hotelData.findHotelByMunicipioId(municipioId);
    }
    public Municipio getMunicipioDeHotel(Integer hotelId) {
        Hotel hotel = classData.findATById(hotelId);
        if (hotel == null) {
            return null;
        }
        return municipioData.findATById(hotel.getMunicipioId());
    }
}