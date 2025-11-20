/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Hotel;
import java.util.List;
import java.util.ArrayList;

public class HotelRepository {
    private IDataAccess<Hotel> dataAccess;
    
    public HotelRepository() {
        this.dataAccess = new JsonRepository<>("hoteles.json", Hotel.class);
    }
    
    // Constructor for dependency injection
    public HotelRepository(IDataAccess<Hotel> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<Hotel> getAllHoteles() {
        return dataAccess.findAll();
    }
    
    public Hotel findHotelById(Integer id) {
        return dataAccess.findById(id);
    }
    
    public void saveHotel(Hotel hotel) {
        dataAccess.save(hotel);
    }
    
    public void deleteHotel(Integer id) {
        dataAccess.delete(id);
    }
}