
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Factura;

public class FacturasRepository extends GeneralRepository<Factura> {
    
    public FacturasRepository() {
        this.dataAccess = new JsonRepository<>("facturas.json", Factura.class);
    }
    public FacturasRepository(IDataAccess<Factura> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}