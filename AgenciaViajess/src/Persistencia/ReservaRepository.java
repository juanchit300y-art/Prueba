/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Reserva;

public class ReservaRepository extends GeneralRepository<Reserva>{
    
    
    public ReservaRepository() {
        this.dataAccess = new JsonRepository<>("Reservas.json", Reserva.class);
    }
    public ReservaRepository(IDataAccess<Reserva> dataAccess) {
        this.dataAccess = dataAccess;
    }
}