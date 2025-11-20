
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Guia;

public class GuiaRepository extends GeneralRepository<Guia> {
    
    public GuiaRepository() {
        this.dataAccess = new JsonRepository<>("guia.json", Guia.class);
    }
    public GuiaRepository(IDataAccess<Guia> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}