/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Reserva;
import java.util.List;
import java.util.ArrayList;

public class ReservaRepository {
    private IDataAccess<Reserva> dataAccess;
    
    public ReservaRepository() {
        this.dataAccess = new JsonRepository<>("Reservas.json", Reserva.class);
    }
    
    // Constructor for dependency injection
    public ReservaRepository(IDataAccess<Reserva> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
    public List<Reserva> getAllReservas() {
        return dataAccess.findAll();
    }
    
    public Reserva findReservaById(Integer id) {
        return dataAccess.findById(id);
    }
    
    public void saveReserva(Reserva reserva) {
        dataAccess.save(reserva);
    }
    
    public void deleteReserva(Integer id) {
        dataAccess.delete(id);
    }
}