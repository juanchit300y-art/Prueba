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

    private PlanController planController;
    public EntretenimientoController() {
        this.classData= new EntretenimientoRepository();
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.elementoPlanController= new ElementoPlanController();
        this.planController = new PlanController();
    }
    public EntretenimientoController(EntretenimientoRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.elementoPlanController= new ElementoPlanController();
        this.planController = new PlanController();
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
    
    public List<Plan> planesMin3ActividadesE(){
    List<Plan> respuesta = new ArrayList<>();
    List<Plan> planes = planData.getAllT();
    if (planes == null) return respuesta;
    for (Plan actual : planes) {
        List<?> elementos = elementoPlanController.getElementosPlanByPlan(actual.getId());
        if (elementos != null && elementos.size() >= 3) {
            respuesta.add(actual);
        }
    }
    return respuesta;
}
    

}