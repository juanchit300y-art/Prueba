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
public class AerolineaController extends GeneralController<Aerolinea> {
    private AeronaveRepository aeronaveData;
    private TrayectoRepository trayectoData;
    private ServicioTransporteRepository servicioTransporteData;
 
    public AerolineaController() {
        this.classData= new AerolineaRepository();
        this.aeronaveData= new AeronaveRepository();
        this.trayectoData = new TrayectoRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
    }
    public AerolineaController(AerolineaRepository classData) {
        this.classData= classData;
        this.aeronaveData= new AeronaveRepository();
        this.trayectoData = new TrayectoRepository();
        this.servicioTransporteData = new ServicioTransporteRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        List<Aeronave> aeronavesAerolinea= aeronaveData.findAAeronavesByAerolineaId(id);        
        if (!aeronavesAerolinea.isEmpty()) {
            return false; 
        }
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarAerolinea(Integer id, String nombre, String correo) {
        Aerolinea aerolinea = classData.findATById(id);
        if (aerolinea == null) {
            return false;
        }
        if (nombre != null && !nombre.trim().isEmpty()) {
            aerolinea.setNombre(nombre.trim());
        }
        if (correo != null && !correo.trim().isEmpty()) {
            aerolinea.setCorreo(correo.trim());
        }
        classData.saveT(aerolinea);
        return true;
    }

    public boolean añadirAerolinea(String nombre, String correo) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }        
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre(nombre.trim());
        aerolinea.setCorreo(correo);
        
        classData.saveT(aerolinea);
        return true;
    }
    // Aeronave Relacionm (caso profesor)
    public List<Aeronave> getAeronavesDeAerolinea(Integer aerolineaId){ 
        return aeronaveData.findAAeronavesByAerolineaId(aerolineaId);
    }
    public boolean assignAeronaveToAerolinea(Integer aerolineaId, Integer aeronaveId) {
        Aerolinea aerolinea = classData.findATById(aerolineaId);
        Aeronave aeronave = aeronaveData.findATById(aeronaveId);
        
        if (aerolinea == null || aeronave == null) {
            return false;
        }
        
        aeronave.setAerolineaId(aerolineaId);
        aeronaveData.saveT(aeronave);
        return true;
    }
    
    //METODO B
    
    public Double MetodoB(Integer aerolineaId){
        Double respuesta = null;
        List<Aeronave> aeronaves = getAeronavesDeAerolinea(aerolineaId);
        Double menor = Double.MAX_VALUE;
        for(Aeronave actual:aeronaves){
            List<ServicioTransporte> serviciosTransporte = servicioTransporteData.findServicioTransporteByVehiculoId(actual.getId());
            for(ServicioTransporte actual2:serviciosTransporte){
                if(actual2.getCosto()<menor){
                    menor = actual2.getCosto();
                    respuesta= actual2.getCosto();
                }
            }
        }        
        return respuesta;
    }
    // Verificador Aeronave pertenece a Aerolinea
    public  boolean verificadorAerolineaH(Integer idAeronave, Integer idAerolinea ){
        List<Aeronave> aeronavesAerolinea= getAeronavesDeAerolinea(idAerolinea);
        for(Aeronave actual: aeronavesAerolinea){
            Integer idAeronaveActual= actual.getId();
            if(idAeronaveActual.equals(idAeronave)){
                return true;
            }
        }
        return false;
    }
    
    
}
