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
public class EntretenimientoController extends GeneralController<Entretenimiento> {
    ViajeRepository viajeData;
    PlanRepository planData;
    EntretenimientoRepository entretenimientoData;
    public EntretenimientoController() {
        this.classData= new EntretenimientoRepository();
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
    }
    public EntretenimientoController(EntretenimientoRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.planData= new PlanRepository();
        this.entretenimientoData= new EntretenimientoRepository();
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
}