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
public class ViajeController extends GeneralController<Viaje> {
    private EntretenimientoRepository entretenimientoData;
    private CuotaRepository cuotaData;
    private ItinerarioTransporteRepository itinerarioTransporteData;
    private FacturaRepository facturaData;
    private TrayectoController controladorTrayecto; 
    private PlanController controladorPlan;
    
    
    public ViajeController() {
        this.classData= new ViajeRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.cuotaData= new CuotaRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorTrayecto= new TrayectoController();
        this.controladorPlan= new PlanController();
    }
    public ViajeController(ViajeRepository classData) {
        this.classData= classData;
        this.entretenimientoData= new EntretenimientoRepository();
        this.cuotaData= new CuotaRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorTrayecto= new TrayectoController();
        this.controladorPlan= new PlanController();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        
        List<Entretenimiento> EntretenimientosViaje= entretenimientoData.findEntretenimientosByViajeId(id);
        if (!EntretenimientosViaje.isEmpty()) {
            return false; 
        }
        
        List<Cuota> cuotaViaje = cuotaData.findCuotasByViajeId(id);
        if (!cuotaViaje.isEmpty()) {
            return false; 
        }
        
        List<ItinerarioTransporte> itinerariosTransporteViaje= itinerarioTransporteData.findItinerarioTransportByViajeId(id);
        if (!itinerariosTransporteViaje.isEmpty()) {
            return false; 
        }
        
        List<Factura> facturasViaje= facturaData.findFacturasByViajeId(id);
        if (!facturasViaje.isEmpty()) {
            return false; 
        }
        
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarViaje(Integer id) {
        Viaje viaje = classData.findATById(id);
        if (viaje == null) {
            return false;
        }
        
        classData.saveT(viaje);
        return true;
    }

    public boolean añadirViaje() {
        Viaje viaje = new Viaje();
        classData.saveT(viaje);
        return true;
    }
    
    //Relacion lista Entretenimiento (caso profesor)
    public List<Entretenimiento> getEntretenimientosDeViaje(Integer viajeId){ 
        return entretenimientoData.findEntretenimientosByViajeId(viajeId);
    }
    public boolean assignEntretenimientoToViaje(Integer viajeId, Integer entretenimientoId) {
        Viaje viaje = classData.findATById(viajeId);
        Entretenimiento entretenimiento = entretenimientoData.findATById(entretenimientoId);
        
        if (viaje == null || entretenimiento == null) {
            return false;
        }
        
        entretenimiento.setViajeId(viajeId);
        entretenimientoData.saveT(entretenimiento);
        return true;
    }
    
    //Relacion lista Factura (caso profesor)
    public List<Factura> getFacturasDeViaje(Integer viajeId){ 
        return facturaData.findFacturasByViajeId(viajeId);
    }
    public boolean assignFacturatoToViaje(Integer viajeId, Integer facturaId) {
        Viaje viaje = classData.findATById(viajeId);
        Factura factura = facturaData.findATById(facturaId);
        
        if (viaje == null || factura == null) {
            return false;
        }
        
        factura.setViajeId(viajeId);
        facturaData.saveT(factura);
        return true;
    }
    
    //Relacion lista Cuota (caso profesor)
    public List<Cuota> getCuotasDeViaje(Integer viajeId){ 
        return cuotaData.findCuotasByViajeId(viajeId);
    }
    public boolean assignCuotaToViaje(Integer viajeId, Integer cuotaId) {
        Viaje viaje = classData.findATById(viajeId);
        Cuota cuota = cuotaData.findATById(cuotaId);
        
        if (viaje == null || cuota == null) {
            return false;
        }
        
        cuota.setViajeId(viajeId);
        cuotaData.saveT(cuota);
        return true;
    }
    
    //Relacion lista ItinerarioTransporte (caso profesor)
    public List<ItinerarioTransporte> getItinerariosTransporteDeViaje(Integer viajeId){ 
        return itinerarioTransporteData.findItinerarioTransportByViajeId(viajeId);
    }
    public boolean assignItinerarioTransporteToViaje(Integer viajeId, Integer itinerarioTransporteId) {
        Viaje viaje = classData.findATById(viajeId);
        ItinerarioTransporte itinerarioTransporte = itinerarioTransporteData.findATById(itinerarioTransporteId);
        
        if (viaje == null || itinerarioTransporte == null) {
            return false;
        }
        
        itinerarioTransporte.setViajeId(viajeId);
        itinerarioTransporteData.saveT(itinerarioTransporte);
        return true;
    }
    //Metodo A
    public Double metodoA(){
        double numActividades=0;
        double numPlanes=0;        
        double respuesta;
        List<Viaje> viajes= getAllGeneral();
        for(Viaje actual : viajes){
            Integer idActual= actual.getId();
            List<ItinerarioTransporte> itinerariosTransporte= getItinerariosTransporteDeViaje(idActual);
            for(ItinerarioTransporte actual2: itinerariosTransporte){
                Integer idTrayecto= actual2.getTrayectoId();
                if(this.controladorTrayecto.verificadorAereo(idTrayecto) && this.controladorTrayecto.verificadorTerrestre(idTrayecto)){
                  List<Entretenimiento> entretenimientoViaje= getEntretenimientosDeViaje(idActual);
                  numPlanes= entretenimientoViaje.size()+ numPlanes;
                  for (Entretenimiento actual3 : entretenimientoViaje){
                      Integer idPlan= actual3.getPlanId();
                      numActividades= this.controladorPlan.numActividadesXPlan(idPlan)+ numActividades;
                    }
                }
            }
        }
        respuesta= numActividades/numPlanes;
        return respuesta;
    }
    //Metodo C
    public int metodoC(){
        int respuesta=0;
        List<Viaje> viajesT= getAllGeneral();
        for(Viaje actual: viajesT){
            List<Entretenimiento> entretenimientoViaje=getEntretenimientosDeViaje(actual.getId());
            
        }
        return respuesta;
    }
}
