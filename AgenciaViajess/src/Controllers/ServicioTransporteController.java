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
    private CarroRepository carroData;
    private AeronaveRepository aeronaveData;
    private TrayectoRepository trayectoData;
    private ServicioTransporteRepository servicioTransporteData;
    private AerolineaController aerolineaController;
    public ServicioTransporteController() {
        this.classData= new ServicioTransporteRepository();
        this.carroData= new CarroRepository();
        this.aeronaveData= new AeronaveRepository();
        this.trayectoData= new TrayectoRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
        this.aerolineaController= new AerolineaController();
    }
    public ServicioTransporteController(ServicioTransporteRepository classData) {
        this.classData= classData;
        this.carroData= new CarroRepository();
        this.aeronaveData= new AeronaveRepository();
        this.trayectoData= new TrayectoRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
        this.aerolineaController= new AerolineaController();
    }
   
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarServicioTransporte(Integer id, Double costo, String fecha_inicio, String fecha_fin, Integer opcion,Integer vehiculoId , Integer trayectoId) {
        ServicioTransporte servicioTransporte = classData.findATById(id);
        if (servicioTransporte == null) {
            return false;
        }
        if(costo!=null && costo>=0){
            servicioTransporte.setCosto(costo);
        }
        
        if (fecha_inicio != null && !fecha_inicio.trim().isEmpty()) {
            servicioTransporte.setFecha_inicio(fecha_inicio.trim());
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

    public boolean añadirServicioTransporte(Integer id, Double costo, String fecha_inicio, String fecha_fin, Integer opcion, Integer vehiculoId, Integer trayectoId) {
        if (fecha_inicio == null || fecha_inicio.trim().isEmpty()) {
            return false;
        }
        if(costo==null && costo<0){
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
        servicioTransporte.setCosto(costo);
        servicioTransporte.setFecha_inicio(fecha_inicio);
        servicioTransporte.setFecha_fin(fecha_fin);
        servicioTransporte.setVehiculoId(vehiculoId);
        servicioTransporte.setTrayectoId(trayectoId);
        
        classData.saveT(servicioTransporte);
        return true;
    }
    
    
    //Relacion a Trayecto (caso curso)
    public List<ServicioTransporte> getServiciosTransporteByTrayecto(Integer trayectoId) {
        return servicioTransporteData.findServicioTransporteByTrayectoId(trayectoId);
    }
    public Trayecto getTrayectoDeServicioTransporte(Integer servicioTransporteId) {
        ServicioTransporte servicioTransporte = classData.findATById(servicioTransporteId);
        if (servicioTransporte == null) {
            return null;
        }
        return trayectoData.findATById(servicioTransporte.getTrayectoId());
    }
    
    //Relacion a Vehiculo (caso curso)
    public List<ServicioTransporte> getServiciosTransporteByVehiculo(Integer vehiculoId) {
        return servicioTransporteData.findServicioTransporteByVehiculoId(vehiculoId);
    }
    public Vehiculo getVehiculoDeServicioTransporte(Integer servicioTransporteId) {
        ServicioTransporte servicioTransporte = classData.findATById(servicioTransporteId);
        if (servicioTransporte == null) {
            return null;
        }
        if(carroData.findATById(servicioTransporte.getVehiculoId())!= null){
            return carroData.findATById(servicioTransporte.getVehiculoId());
        }
        
        if(aeronaveData.findATById(servicioTransporte.getVehiculoId())!= null){
            return aeronaveData.findATById(servicioTransporte.getVehiculoId());
        }
        return null;
    }
    // vehiculos servicio transporte
    public List<Integer> verificadorVehiculoHotelMenosH(Integer idTrayecto){
        List<ServicioTransporte> serviciosTransporteT= getServiciosTransporteByTrayecto(idTrayecto);
        List<Integer> idVehiculos= new ArrayList<>();
        for(ServicioTransporte actual: serviciosTransporteT){
            Integer idVehiculoS= actual.getVehiculoId();
            idVehiculos.add(idVehiculoS);
        }
        return idVehiculos;
    }
    // Costo segun trayecto
    public Double costoXTrayectoAereo(Integer idTrayecto){
        Double respuesta=0.0;
        List<ServicioTransporte> serviciosTransporteXTrayecto= getServiciosTransporteByTrayecto(idTrayecto);
        for(ServicioTransporte actual :serviciosTransporteXTrayecto){
            if(servicioAereo(actual)){
                respuesta= actual.getCosto() + respuesta;
            }
        }
        return respuesta;
    }
    //Verificacion Aereo
    public boolean servicioAereo(ServicioTransporte actual){
        List<Aeronave> aeronaves = aeronaveData.getAllT();
        for(Aeronave actual3: aeronaves){
            if(actual.getVehiculoId().equals(actual3.getId())){
                return true;
            }
        }
        return false;
    }
    //Suma costos MetodoI
    public Double costoXTrayecto(Integer idTrayecto){
        Double respuesta=0.0;
        List<ServicioTransporte> serviciosTransporteXTrayecto= getServiciosTransporteByTrayecto(idTrayecto);
        for(ServicioTransporte actual :serviciosTransporteXTrayecto){
                respuesta= actual.getCosto() + respuesta;
        }
        return respuesta;
    }
    // Verificacion Aerolinea
    public boolean verificacionIdVehiculoXAerolinea(Integer idTrayecto, Integer idAerolinea){
        List<ServicioTransporte> serviciosTransporteXTrayecto= getServiciosTransporteByTrayecto(idTrayecto);
        for(ServicioTransporte actual : serviciosTransporteXTrayecto){
            if(servicioAereo(actual)){
                Integer idVehiculo= actual.getVehiculoId();
                boolean resultado= aerolineaController.verificadorAerolineaH(idVehiculo, idAerolinea);
                if (resultado){
                    return true;
                } 
            }
        }
        return false; 
    }
}
