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
    EntretenimientoRepository entretenimientoData;
    CuotaRepository cuotaData;
    ItinerarioTransporteRepository itinerarioTransporteData;
    FacturaRepository facturaData;
    
    
    public ViajeController() {
    }
    public ViajeController(ViajeRepository classData) {
        this.classData= new ViajeRepository();
        this.entretenimientoData= new EntretenimientoRepository();
        this.cuotaData= new CuotaRepository();
        this.itinerarioTransporteData= new ItinerarioTransporteRepository();
        this.facturaData= new FacturaRepository();
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
}
