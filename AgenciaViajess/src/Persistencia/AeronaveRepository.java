/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Aeronave;

public class AeronaveRepository extends GeneralRepository<Aeronave> {    
    public AeronaveRepository() {
        this.dataAccess = new JsonRepository<>("aeronaves.json", Aeronave.class);
    }
    public AeronaveRepository(IDataAccess<Aeronave> dataAccess) {
        this.dataAccess = dataAccess;
    }
}