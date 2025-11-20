
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Factura;
import java.util.ArrayList;
import java.util.List;

public class FacturaRepository extends GeneralRepository<Factura> {
    
    public FacturaRepository() {
        this.dataAccess = new JsonRepository<>("facturas.json", Factura.class);
    }
    public FacturaRepository(IDataAccess<Factura> dataAccess) {
        this.dataAccess = dataAccess;
    }
    
   public List<Factura> findFacturasByViajeId(Integer viajeId) {
        List<Factura> facturas = getAllT();
        List<Factura> result = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getViajeId() != null && factura.getViajeId().equals(viajeId)) {
                result.add(factura);
            }
        }
        return result;
    }
   
    public List<Factura> findFacturasByClienteId(Integer clienteId) {
        List<Factura> facturas = getAllT();
        List<Factura> result = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.getClienteId() != null && factura.getClienteId().equals(clienteId)) {
                result.add(factura);
            }
        }
        return result;
    }
}