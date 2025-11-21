/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.List;


/**
 *
 * @author DELL
 */
public class FacturaController extends GeneralController<Factura> {
    ViajeRepository viajeData;
    ClienteRepository clienteData;
    public FacturaController() {
    }
    public FacturaController(FacturaRepository classData) {
        this.classData= new FacturaRepository();
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarFactura(Integer id, Integer viajeId, Integer clienteId) {
        Factura factura = classData.findATById(id);
        if (factura == null) {
            return false;
        }
        if (viajeId != null) {
            Viaje viaje = viajeData.findATById(viajeId);
            if (viaje == null) {
                return false;
            }
            factura.setViajeId(viajeId);
        }
        if(clienteId!= null){
            Cliente cliente= clienteData.findATById(clienteId);
            if(cliente== null){
                return false;
            }
            factura.setClienteId(clienteId);
        }        
        classData.saveT(factura);
        return true;
    }

    public boolean añadirFactura(Integer viajeId, Integer clienteId) {
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        Cliente cliente = clienteData.findATById(clienteId);
        if (cliente == null) {
            return false;
        }
        Factura factura = new Factura();
        factura.setViajeId(viajeId);
        factura.setClienteId(clienteId);
        
        classData.saveT(factura);
        return true;
    }
}