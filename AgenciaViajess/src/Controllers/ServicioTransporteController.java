/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DELL
 */
public class ServicioTransporteController extends GeneralController<ServicioTransporte> {
    VehiculoRepository vehiculoData;
    TrayectoRepository trayectoData;
    
    public ServicioTransporteController() {
    }
    public ServicioTransporteController(ServicioTransporteRepository classData) {
        this.classData= new ServicioTransporteRepository();
        this.vehiculoData= new VehiculoRepository();
        this.trayectoData= new TrayectoRepository();
    
    }
   
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarServicioTransporte(Integer id,String fecha_inicio, String fecha_fin, Integer vehiculoId, Integer trayectoId) {
        ServicioTransporte servicioTransporte = classData.findATById(id);
        if (servicioTransporte == null) {
            return false;
        }
        if (fecha_inicio != null && !fecha_inicio.trim().isEmpty()) {
            servicioTransporte.setFecha_inicio(fecha_inicio.trim());
        }
        
        if (fecha_fin != null && !fecha_fin.trim().isEmpty()) {
            servicioTransporte.setFecha_fin(fecha_fin.trim());
        }
        
        if(vehiculoId != null){
            Vehiculo vehiculo = vehiculoData.findATById(vehiculoId);
            if (vehiculo == null) {
                return false;
            }
            servicioTransporte.setVehiculoId(vehiculoId);
        }
        
        if (trayectoId != null) {
            Trayecto trayecto = trayectoData.findATById(trayectoId);
            if (trayecto == null) {
                return false;
            }
            servicioTransporte.setTrayectoId(trayectoId);
        }

        classData.saveT(servicioTransporte);
        return true;
    }

    public boolean añadirReserva(Integer id,String fecha_inicio, String fecha_fin, Integer vehiculoId, Integer trayectoId) {
        if (fecha_inicio == null || fecha_inicio.trim().isEmpty()) {
            return false;
        }
        
        if (fecha_fin == null || fecha_fin.trim().isEmpty()) {
            return false;
        }
        
        Vehiculo vehiculo = vehiculoData.findATById(vehiculoId);
        if (vehiculo == null) {
            return false;
        }
        
        Trayecto trayecto = trayectoData.findATById(trayectoId);
        if (trayecto == null) {
            return false;
        }
        ServicioTransporte servicioTransporte = new ServicioTransporte();
        servicioTransporte.setFecha_inicio(fecha_inicio);
        servicioTransporte.setFecha_fin(fecha_fin);
        servicioTransporte.setVehiculoId(vehiculoId);
        servicioTransporte.setTrayectoId(trayectoId);
        
        classData.saveT(servicioTransporte);
        return true;
    }
}