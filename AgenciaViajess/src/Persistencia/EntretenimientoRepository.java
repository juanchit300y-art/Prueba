
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Entretenimiento;

public class EntretenimientoRepository extends GeneralRepository<Entretenimiento> {
    
    public EntretenimientoRepository() {
        this.dataAccess = new JsonRepository<>("entretenimiento.json", Entretenimiento.class);
    }
    public EntretenimientoRepository(IDataAccess<Entretenimiento> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}