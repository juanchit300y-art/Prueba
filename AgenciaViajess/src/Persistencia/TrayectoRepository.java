/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Trayecto;

public class TrayectoRepository extends GeneralRepository<Trayecto>{
    
    
    public TrayectoRepository() {
        this.dataAccess = new JsonRepository<>("Trayectos.json", Trayecto.class);
    }
    public TrayectoRepository(IDataAccess<Trayecto> dataAccess) {
        this.dataAccess = dataAccess;
    }
}