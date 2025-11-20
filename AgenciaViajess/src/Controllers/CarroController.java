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
public class CarroController extends GeneralController<Carro> {
    HotelRepository hotelData;
    
    public CarroController() {
    }
    public CarroController(CarroRepository classData) {
        this.classData= new CarroRepository();
        this.hotelData= new HotelRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarCarro(Integer id, String marca, Integer hotelId) {
        Carro carro = classData.findATById(id);
        if (carro == null) {
            return false;
        }
        if (marca != null && !marca.trim().isEmpty()) {
            carro.setMarca(marca.trim());
        }
        if (hotelId != null) {
            Hotel hotel = hotelData.findATById(hotelId);
            if (hotel == null) {
                return false;
            }
            carro.setHotelId(hotelId);
        }
        classData.saveT(carro);
        return true;
    }

    public boolean añadirCarro(String marca, Integer hotelId) {
        if (marca == null || marca.trim().isEmpty()) {
            return false;
        }
        Hotel hotel = hotelData.findATById(hotelId);
        if (hotel == null) {
            return false;
        }
        Carro carro = new Carro();
        carro.setMarca(marca.trim());
        carro.setHotelId(hotelId);
        
        classData.saveT(carro);
        return true;
    }
}