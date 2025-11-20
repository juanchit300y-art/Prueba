/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Turno;

public class TurnoRepository extends GeneralRepository<Turno>{
    
    
    public TurnoRepository() {
        this.dataAccess = new JsonRepository<>("Turnos.json", Turno.class);
    }
    public TurnoRepository(IDataAccess<Turno> dataAccess) {
        this.dataAccess = dataAccess;
    }
}