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
public class EntretenimientoController extends GeneralController<Entretenimiento> {
    private ViajeRepository viajeData;
    private PlanRepository planData;
    private EntretenimientoRepository entretenimientoData;
    private ElementoPlanController elementoPlanController;
    private TrayectoController trayectoController;
    private ItinerarioTransporteController itinerarioTransporteController;
    private ActividadTuristicaRepository actividadTuristicaRepository;
    private ElementoPlanRepository elementoPlanRepository;
    private PlanController planController;
    private ActividadTuristicaController actividadTuristicaController;
    public EntretenimientoController() {
        this.classData= new EntretenimientoRepository();
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.elementoPlanController= new ElementoPlanController();
        this.planController = new PlanController();
        this.trayectoController = new TrayectoController();
        this.itinerarioTransporteController = new ItinerarioTransporteController();
        this.actividadTuristicaRepository = new ActividadTuristicaRepository();
        this.elementoPlanRepository = new ElementoPlanRepository();
        this.actividadTuristicaController = new ActividadTuristicaController();
        
    }
    public EntretenimientoController(EntretenimientoRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.elementoPlanController= new ElementoPlanController();
        this.planController = new PlanController();
        this.trayectoController = new TrayectoController();
        this.itinerarioTransporteController = new ItinerarioTransporteController();
        this.actividadTuristicaRepository = new ActividadTuristicaRepository();
        this.elementoPlanRepository = new ElementoPlanRepository();
        this.actividadTuristicaController = new ActividadTuristicaController();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarEntretenimiento(Integer id, Integer viajeId, Integer planId) {
        Entretenimiento entretenimiento = classData.findATById(id);
        if (entretenimiento == null) {
            return false;
        }
        if (viajeId != null) {
            Viaje viaje = viajeData.findATById(viajeId);
            if (viaje == null) {
                return false;
            }
            entretenimiento.setViajeId(viajeId);
        }
        if(planId!= null){
            Plan plan= planData.findATById(planId);
            if(plan== null){
                return false;
            }
            entretenimiento.setPlanId(planId);
        }        
        classData.saveT(entretenimiento);
        return true;
    }

    public boolean añadirEntretenimiento(Integer viajeId, Integer planId) {
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        Plan plan = planData.findATById(planId);
        if (plan == null) {
            return false;
        }
        Entretenimiento entretenimiento = new Entretenimiento();
        entretenimiento.setViajeId(viajeId);
        entretenimiento.setPlanId(planId);
        
        classData.saveT(entretenimiento);
        return true;
    }
    //Relacion Plan (caso curso)
    public List<Entretenimiento> getEntrenimientosByPlan(Integer planId) {
        return entretenimientoData.findEntretenimientosByPlanId(planId);
    }
    public Plan getPlanDeEntretenimiento(Integer entretenimientoId) {
        Entretenimiento entretenimiento = classData.findATById(entretenimientoId);
        if (entretenimiento == null) {
            return null;
        }
        return planData.findATById(entretenimiento.getPlanId());
    }
    //Relacion Viaje (caso curso)
    public List<Entretenimiento> getEntrenimientosByViaje(Integer viajeId) {
        return entretenimientoData.findEntretenimientosByViajeId(viajeId);
    }
    public Viaje getViajeDeEntretenimiento(Integer entretenimientoId) {
        Entretenimiento entretenimiento = classData.findATById(entretenimientoId);
        if (entretenimiento == null) {
            return null;
        }
        return viajeData.findATById(entretenimiento.getViajeId());
    }
    // Interconexion Viaje-Plan
    public boolean verificadorIdMunicipioH(Integer viajeId, Integer municipioId){
        List<Entretenimiento> entretenimientosViaje= getEntrenimientosByViaje(viajeId);
        for(Entretenimiento actual : entretenimientosViaje){
            Integer idPlan= actual.getPlanId();
            boolean resultado = elementoPlanController.verificacionActividadMunicipioH(idPlan, municipioId) ;
            if (resultado){
                return true;
            }
        }
        return false;
    }
    
    public List<Viaje> viajesTerrestresG(){
        List<Viaje> viajes = viajeData.getAllT();
        List<Viaje> respuesta = new ArrayList<>();
        for(Viaje actual:viajes){
            List<ItinerarioTransporte> itinerariosViaje = itinerarioTransporteController.getItinerariosTransporteByViaje(actual.getId());
            for(ItinerarioTransporte actual2:itinerariosViaje){
                Trayecto trayectoViaje = itinerarioTransporteController.getTrayectoDeItinerarioTransporte(actual2.getId());
                if(trayectoController.verificadorTerrestre(trayectoViaje.getId())){
                    if(!respuesta.contains(actual)){
                        respuesta.add(actual);
                }
                }
            }
        }
        return respuesta;
    }
    
    public int metodoG(){
        List<Viaje> viajesTerrestres = viajesTerrestresG();
        int respuesta = 0;
        int mayor = Integer.MIN_VALUE;
        for(Viaje actual:viajesTerrestres){
            List<Entretenimiento> entretenimientoDeViaje = getEntrenimientosByViaje(actual.getId());
            for(Entretenimiento actual2:entretenimientoDeViaje){
                Plan planDelEntretenimiento = getPlanDeEntretenimiento(actual2.getId());
                List<ElementoPlan> elementosDelPlan = planController.getElementosPlanDePlan(planDelEntretenimiento.getId());
                if(elementosDelPlan.size()>mayor){
                    mayor=elementosDelPlan.size();
                    respuesta=elementosDelPlan.size();
                }
            }
            
        }
        return respuesta;
    }
    public List<Plan> planesActId(Integer idActividad){
        List<Plan> respuesta = new ArrayList<>();
        List<Plan> planes = planData.getAllT();
        for(Plan actual:planes  ){
            List<ElementoPlan> elementosPlanDePlan = elementoPlanController.getElementosPlanByPlan(actual.getId());
            for(ElementoPlan actual2 : elementosPlanDePlan){
                if(actual2.getActividadTuristicaId().equals(idActividad)){
                    respuesta.add(actual);
                    break;
                }
            }
        }
        return respuesta;
    }
    
    public List<Plan> planes3Actividades(){
        List<Plan> respuesta = new ArrayList<>();
        List<Plan> planes = planData.getAllT();
        for(Plan actual:planes){
            List<ElementoPlan> elementosPlan = elementoPlanController.getElementosPlanByPlan(actual.getId());
            if(elementosPlan.size()>=3){
                respuesta.add(actual);
            }
        }
        return respuesta;
    }
    
    public List<Plan> planesByViaje(Integer viajeId){
    List<Plan> respuesta = new ArrayList<>();
    List<Entretenimiento> entretenimientosViaje = getEntrenimientosByViaje(viajeId);

    for(Entretenimiento actual : entretenimientosViaje){
        Plan plan = getPlanDeEntretenimiento(actual.getId());
        if(plan != null && !respuesta.contains(plan)){
            respuesta.add(plan);
        }
    }
    return respuesta;
}


    
    public List<Viaje> viajesByPlan3Act(){
        List<Viaje> respuesta = new ArrayList<>();
        List<Plan> planes3Act =  planes3Actividades();
        List<Viaje> viajes = viajeData.getAllT();
        for(Viaje actual:viajes){
            List<Plan> planesDeViaje = planesByViaje(actual.getId());
            for(Plan actual2:planesDeViaje){
                for(Plan actual3:planes3Act){
                    if(actual2.getId().equals(actual3.getId())){
                        if(!respuesta.contains(actual)){
                            respuesta.add(actual);
                        }
                    }
                }
            }
        }
        return respuesta;
    }
    
    
}