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
    private ViajeRepository viajeData;
    private ClienteRepository clienteData;
    private FacturaRepository facturaData;
    public FacturaController() {
        this.classData= new FacturaRepository();
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
    }
    public FacturaController(FacturaRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarFactura(Integer id,Integer costo,  Integer viajeId, Integer clienteId) {
        Factura factura = classData.findATById(id);
        if (factura == null) {
            return false;
        }
        if (costo != null && costo<0) {
            factura.setCosto(costo);
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

    public boolean añadirFactura(Integer costo, Integer viajeId, Integer clienteId) {
        if (costo == null || costo<1) {
            return false;
        }
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        Cliente cliente = clienteData.findATById(clienteId);
        if (cliente == null) {
            return false;
        }
        Factura factura = new Factura();
        factura.setCosto(costo);
        factura.setViajeId(viajeId);
        factura.setClienteId(clienteId);
        
        classData.saveT(factura);
        return true;
    }
    //Cliente relacion (caso curso)
    public List<Factura> getFacturasByCliente(Integer clienteId) {
        return facturaData.findFacturasByClienteId(clienteId);
    }
    public Cliente getClienteDeFactura(Integer facturaId) {
        Factura factura = classData.findATById(facturaId);
        if (factura == null) {
            return null;
        }
        return clienteData.findATById(factura.getClienteId());
    }
    //Viaje relacion (caso curso)    
    public List<Factura> getFacturasByViaje(Integer viajeId) {
        return facturaData.findFacturasByViajeId(viajeId);
    }
    public Viaje getViajeDeFactura(Integer facturaId) {
        Factura factura = classData.findATById(facturaId);
        if (factura == null) {
            return null;
        }
        return viajeData.findATById(factura.getViajeId());
    }
}