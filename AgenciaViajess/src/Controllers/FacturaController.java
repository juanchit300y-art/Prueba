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
    private ItinerarioTransporteController controladorItinerario;
    private EntretenimientoController controladorEntretenimiento;
    public FacturaController() {
        this.classData= new FacturaRepository();
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorItinerario= new ItinerarioTransporteController();
        this.controladorEntretenimiento= new EntretenimientoController();
    }
    public FacturaController(FacturaRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorItinerario= new ItinerarioTransporteController();
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
    //Metodo D
    public Double metodoD(Integer idCliente){
        Double respuesta=0.0;
        List<Factura> facturasXCliente= getFacturasByCliente(idCliente);
        for(Factura actual : facturasXCliente){
            Integer viajeId= actual.getViajeId();
            Double sumar= controladorItinerario.costoTrayectoXViaje(viajeId);
            respuesta= sumar + respuesta;
        }
        return respuesta;
    }
    // Metodo H
    public int metodoH(Integer idAerolinea, Integer idMunicipio){
        int respuesta=0;
        List<Cliente> clientes= clienteData.getAllT();
        for(Cliente actual2 : clientes){ 
            Integer idCliente= actual2.getId();
            List<Factura> facturasXCliente= getFacturasByCliente(idCliente);
            for(Factura actual : facturasXCliente){
                Integer viajeId= actual.getViajeId();
                boolean resultado1= controladorItinerario.revisionViajeAerolinea(viajeId, idAerolinea);
                boolean resultado2= controladorEntretenimiento.verificadorIdMunicipioH(viajeId, idMunicipio);
                if(resultado1 && resultado2 ){
                    respuesta++;
                }
            }
        }
        return respuesta;
    }
    //Metodo F
    public Double metodoF(){
        Double respuesta;
        double numClientes=0;
        double numTrayectos=0;
        List<Cliente> clientes= clienteData.getAllT();
        for(Cliente actual: clientes){
            Integer idClienteActual= actual.getId();
            List<Factura> facturasCliente= getFacturasByCliente(idClienteActual);
            int cantiViajes= facturasCliente.size();
            if(cantiViajes > 1){
                numClientes++;
                for(Factura actual2 : facturasCliente){
                    Integer idViaje= actual2.getViajeId();
                    int promedio= controladorItinerario.numTrayectosF(idViaje);
                    numTrayectos= promedio + numTrayectos;
                }
                
            }
        }
        respuesta= numTrayectos/numClientes;
        return respuesta;
    }
}