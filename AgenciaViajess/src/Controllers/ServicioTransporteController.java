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
    CarroRepository carroData;
    AeronaveRepository aeronaveData;
    TrayectoRepository trayectoData;
   
    public ServicioTransporteController() {
    }
    public ServicioTransporteController(ServicioTransporteRepository classData) {
        this.classData= new ServicioTransporteRepository();
        this.carroData= new CarroRepository();
        this.aeronaveData= new AeronaveRepository();
        this.trayectoData= new TrayectoRepository();
    
    }
   
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarServicioTransporte(Integer id,String fecha_inicio, String fecha_fin, Integer opcion,Integer vehiculoId , Integer trayectoId) {
        ServicioTransporte servicioTransporte = classData.findATById(id);
        if (servicioTransporte == null) {
            return false;
        }
        if (fecha_inicio != null && !fecha_inicio.trim().isEmpty()) {
            servicioTransporte.setFecha_iniciio(fecha_inicio.trim());
        }
        
        if (fecha_fin != null && !fecha_fin.trim().isEmpty()) {
            servicioTransporte.setFecha_fin(fecha_fin.trim());
        }
        if (trayectoId != null) {
            Trayecto trayecto = trayectoData.findATById(trayectoId);
            if (trayecto == null) {
                return false;
            }
            servicioTransporte.setTrayectoId(trayectoId);
        }
        if (opcion != null){
            if(vehiculoId != null && opcion == 1){
                Aeronave aeronave = aeronaveData.findATById(vehiculoId);
                if (aeronave == null) {
                    return false;
                }
                servicioTransporte.setVehiculoId(vehiculoId);
            }
            if(vehiculoId != null && opcion == 2){
                Carro carro = carroData.findATById(vehiculoId);
                if (carro == null) {
                    return false;
                }
                servicioTransporte.setVehiculoId(vehiculoId);
            }
        }    
        classData.saveT(servicioTransporte);
        return true;
    }

    public boolean añadirReserva(Integer id,String fecha_inicio, String fecha_fin, Integer opcion, Integer vehiculoId, Integer trayectoId) {
        if (fecha_inicio == null || fecha_inicio.trim().isEmpty()) {
            return false;
        }
        
        if (fecha_fin == null || fecha_fin.trim().isEmpty()) {
            return false;
        }
        if(opcion == null && opcion>2 && opcion< 1  ){
            return false;
        }
        if (opcion == 1 ){
            Aeronave aeronave = aeronaveData.findATById(vehiculoId);
            if (aeronave == null) {
                return false;
            }
        }
        if (opcion == 2 ){
            Carro carro = carroData.findATById(vehiculoId);
            if (carro == null) {
                return false;
            }
        }
        Trayecto trayecto = trayectoData.findATById(trayectoId);
        if (trayecto == null) {
            return false;
        }
        ServicioTransporte servicioTransporte = new ServicioTransporte();
        servicioTransporte.setFecha_iniciio(fecha_inicio);
        servicioTransporte.setFecha_fin(fecha_fin);
        servicioTransporte.setVehiculoId(vehiculoId);
        servicioTransporte.setTrayectoId(trayectoId);
        
        classData.saveT(servicioTransporte);
        return true;
    }
}