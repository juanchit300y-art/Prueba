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
public class ClienteController extends GeneralController<Cliente> {
    FacturaRepository facturaData;
    
    public ClienteController() {
    }
    public ClienteController(ClienteRepository classData) {
        this.classData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Factura> facturasCliente= facturaData.findFacturasByClienteId(id);        
        if (!facturasCliente.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarCliente(Integer id, String nombre, String contraseña,String correo,  String medioDePago) {
        Cliente cliente = classData.findATById(id);
        if (cliente == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            cliente.setNombre(nombre.trim());
        }
        if (contraseña != null && !contraseña.trim().isEmpty()) {
            cliente.setContraseña(contraseña.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            cliente.setCorreo(correo.trim());
        }
        if (medioDePago != null && !medioDePago.trim().isEmpty()) {
            cliente.setMedioDePago(medioDePago.trim());
        }      

        classData.saveT(cliente);
        return true;
    }

    public boolean añadirCliente(String nombre, String contraseña,String correo,  String medioDePago) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (contraseña == null ||  contraseña.trim().isEmpty()) {
            return false;
        }
        if (correo == null  || correo.trim().isEmpty()) {
            return false;
        }
        if (medioDePago == null  || medioDePago.trim().isEmpty()) {
            return false;
        }  
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre.trim());
        cliente.setContraseña(contraseña);
        cliente.setCorreo(correo);
        cliente.setMedioDePago(medioDePago);
        
        classData.saveT(cliente);
        return true;
    }
}