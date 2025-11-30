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
    private HotelRepository hotelData;
    private ServicioTransporteRepository servicioTransporteData;
    private CarroRepository carroData;
    
    public CarroController() {
        this.classData= new CarroRepository();
        this.hotelData= new HotelRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
        this.carroData= new CarroRepository();
    }
    public CarroController(CarroRepository classData) {
        this.classData= classData;
        this.hotelData= new HotelRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
        this.carroData= new CarroRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<ServicioTransporte> servicioTransporteCarro= servicioTransporteData.findServicioTransporteByVehiculoId(id);
        if (!servicioTransporteCarro.isEmpty()) {
            return false; 
        }
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
    //Relacion Hotel (caso curso)
    public List<Carro> getCarrosByHotel(Integer hotelId) {
        return carroData.findCarrosByHotel(hotelId);
    }
    public Hotel getHotelDeCarro(Integer carroId) {
        Carro carro = classData.findATById(carroId);
        if (carro == null) {
            return null;
        }
        return hotelData.findATById(carro.getHotelId());
    }
    //Relacion Servicio Transporte (Caso profesor)
    public List<ServicioTransporte> getServiciosTransporteDeCarro(Integer carroId){ 
        return servicioTransporteData.findServicioTransporteByVehiculoId(carroId);
    }
    public boolean assignServicioTransporteToCarro(Integer carroId, Integer servicioTransporteId) {
        Carro carro = classData.findATById(carroId);
        ServicioTransporte servicioTransporte = servicioTransporteData.findATById(servicioTransporteId);
        
        if (carro == null || servicioTransporte == null) {
            return false;
        }
        
        servicioTransporte.setVehiculoId(carroId);
        servicioTransporteData.saveT(servicioTransporte);
        return true;
    }
    // Verificador de Pertenencia
    public boolean PertenecAUnHotel(Integer idHotel, Integer idCarro){
        Carro carro= carroData.findATById(idCarro);
        Integer idHotelCarro= carro.getHotelId();
        if (idHotelCarro.equals(idHotel)){
            return true;
        }
        else {
            return false;
        }
    }
}