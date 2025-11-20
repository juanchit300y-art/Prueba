/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;
import java.util.List;
import Modelos.Hotel;

public class HotelRepository extends GeneralRepository<Hotel> {
    
    public HotelRepository() {
        this.dataAccess = new JsonRepository<>("hotel.json", Hotel.class);
    }
    public HotelRepository(IDataAccess<Hotel> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<Hotel> findHotelByMunicipioId(Integer municipioId) {
        List<Hotel> hoteles = getAllT();
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hoteles) {
            if (hotel.getMunicipioId() != null && hotel.getMunicipioId().equals(municipioId)) {
                result.add(hotel);
            }
        }
        return result;
    }
   
}