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
public class CuotaController extends GeneralController<Cuota> {
    private ViajeRepository viajeData;
    private CuotaRepository cuotaData;
    
    public CuotaController() {
        this.classData= new CuotaRepository();
        this.viajeData= new ViajeRepository();
        this.cuotaData= new CuotaRepository();
    }
    public CuotaController(CuotaRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.cuotaData= new CuotaRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarCuota(Integer id, Integer monto, Integer viajeId) {
        Cuota cuota = classData.findATById(id);
        if (cuota == null) {
            return false;
        }
        if (monto != null && monto >0 ) {
            cuota.setMonto(monto);
        }
        if (viajeId != null) {
            
            Viaje viaje = viajeData.findATById(viajeId);
            if (viaje == null) {
                return false;
            }
            cuota.setViajeId(viajeId);
        }

        classData.saveT(cuota);
        return true;
    }

    public boolean añadirCuota( Integer monto, Integer viajeId) {
        if (monto == null || monto < 0) {
            return false;
        }
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        Cuota couta = new Cuota();
        couta.setMonto(monto);
        couta.setViajeId(viajeId);
        
        classData.saveT(couta);
        return true;
    }
    // Viaje Relacion (caso curso)
    public List<Cuota> getCuotasByViaje(Integer viajeId) {
        return cuotaData.findCuotasByViajeId(viajeId);
    }
    public Viaje getViajeDeCuota(Integer cuotaId) {
        Cuota cuota = classData.findATById(cuotaId);
        if (cuota == null) {
            return null;
        }
        return viajeData.findATById(cuota.getViajeId());
    }
}