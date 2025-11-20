
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Cuota;

public class CuotaRepository extends GeneralRepository<Cuota> {
    
    public CuotaRepository() {
        this.dataAccess = new JsonRepository<>("cuota.json", Cuota.class);
    }
    public CuotaRepository(IDataAccess<Cuota> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}