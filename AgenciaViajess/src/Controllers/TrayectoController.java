package Controllers;

import Persistencia.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrayectoController extends GeneralController<Trayecto> {

    private MunicipioRepository municipioData;
    private ItinerarioTransporteRepository itinerarioData;
    private ServicioTransporteRepository servicioData;
    private CarroRepository carroData;
    private AeronaveRepository aeronaveData;

    public TrayectoController() {
        this.classData = new TrayectoRepository();
        this.municipioData = new MunicipioRepository();
        this.itinerarioData = new ItinerarioTransporteRepository();
        this.servicioData = new ServicioTransporteRepository();
        this.carroData = new CarroRepository();
        this.aeronaveData = new AeronaveRepository();
    }

    public TrayectoController(TrayectoRepository classData) {
        this.classData = classData;
        this.municipioData = new MunicipioRepository();
        this.itinerarioData = new ItinerarioTransporteRepository();
        this.servicioData = new ServicioTransporteRepository();
        this.carroData = new CarroRepository();
        this.aeronaveData = new AeronaveRepository();
    }

    @Override
    public boolean eliminarObjeto(Integer id) {

        if (!itinerarioData.findItinerarioTransportByTrayectoId(id).isEmpty())
            return false;

        if (!servicioData.findServicioTransporteByTrayectoId(id).isEmpty())
            return false;

        classData.deleteT(id);
        return true;
    }

    public boolean actualizarTrayecto(Integer id, Integer municipioInicioId, Integer municipioDestinoId) {
        Trayecto trayecto = classData.findATById(id);
        if (trayecto == null) return false;

        if (municipioInicioId != null && municipioData.findATById(municipioInicioId) != null) {
            trayecto.setMunicipioInicioId(municipioInicioId);
        }

        if (municipioDestinoId != null && municipioData.findATById(municipioDestinoId) != null) {
            trayecto.setMunicipioDestinoId(municipioDestinoId);
        }

        classData.saveT(trayecto);
        return true;
    }

    public boolean añadirTrayecto(Integer municipioInicioId, Integer municipioDestinoId) {

        if (municipioData.findATById(municipioInicioId) == null) return false;
        if (municipioData.findATById(municipioDestinoId) == null) return false;

        Trayecto trayecto = new Trayecto();
        trayecto.setMunicipioInicioId(municipioInicioId);
        trayecto.setMunicipioDestinoId(municipioDestinoId);

        classData.saveT(trayecto);
        return true;
    }

    // ======================================================
    //        RELACIONES CORRECTAS
    // ======================================================

    // Municipio inicio
    public Municipio getMunicipioInicioDeTrayecto(Integer trayectoId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        if (trayecto == null) return null;
        return municipioData.findATById(trayecto.getMunicipioInicioId());
    }

    // Municipio destino
    public Municipio getMunicipioDestinoDeTrayecto(Integer trayectoId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        if (trayecto == null) return null;
        return municipioData.findATById(trayecto.getMunicipioDestinoId());
    }

    // Itinerarios asignados al trayecto
    public List<ItinerarioTransporte> getItinerariosTransporteDeTrayecto(Integer trayectoId) {
        return itinerarioData.findItinerarioTransportByTrayectoId(trayectoId);
    }

    public boolean assignItinerarioTransporteToTrayecto(Integer trayectoId, Integer itinerarioId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        ItinerarioTransporte itinerario = itinerarioData.findATById(itinerarioId);

        if (trayecto == null || itinerario == null) return false;

        itinerario.setTrayectoId(trayectoId);
        itinerarioData.saveT(itinerario);
        return true;
    }

    // Servicios asignados al trayecto
    public List<ServicioTransporte> getServiciosTransporteDeTrayecto(Integer trayectoId) {
        return servicioData.findServicioTransporteByTrayectoId(trayectoId);
    }

    public boolean assignServicioTransporteToTrayecto(Integer trayectoId, Integer servicioId) {
        Trayecto trayecto = classData.findATById(trayectoId);
        ServicioTransporte servicio = servicioData.findATById(servicioId);

        if (trayecto == null || servicio == null) return false;

        servicio.setTrayectoId(trayectoId);
        servicioData.saveT(servicio);
        return true;
    }
    
    //lista trayectos terrestre
    public List<Trayecto> getTrayectosTerrestres(){
        List<Trayecto> trayectos = classData.getAllT();
        List<Trayecto> trayectosTerrestres = new ArrayList<>();
        for(Trayecto actual : trayectos){
            List<ServicioTransporte> serviciosTransporte = getServiciosTransporteDeTrayecto(actual.getId());
            for(ServicioTransporte actual2 : serviciosTransporte){
                List<Carro> carros = carroData.getAllT();
                for(Carro actual3:carros){
                    if(actual2.getVehiculoId().equals(actual3.getId())){
                        trayectosTerrestres.add(actual);
                    }
                }
            }
        }
        return trayectosTerrestres;
    }
    
    //lista trayectos Aereos
    public List<Trayecto> getTrayectosAereos(){
        List<Trayecto> trayectos = classData.getAllT();
        List<Trayecto> trayectosAereos = new ArrayList<>();
        for(Trayecto actual : trayectos){
            List<ServicioTransporte> serviciosTransporte = getServiciosTransporteDeTrayecto(actual.getId());
            for(ServicioTransporte actual2 : serviciosTransporte){
                List<Aeronave> aeronaves = aeronaveData.getAllT();
                for(Aeronave actual3:aeronaves){
                    if(actual2.getVehiculoId().equals(actual3.getId())){
                        trayectosAereos.add(actual);
                    }
                }
            }
        }
        return trayectosAereos;
    }
    
    public boolean verificadorTerrestre(Integer trayectoId){
        Trayecto trayecto = classData.findATById(trayectoId);
        List<Trayecto> trayectosTerrestres = getTrayectosTerrestres();
        for(Trayecto actual:trayectosTerrestres){
            if(actual.getId().equals(trayecto.getId())){
                return true;
            }
        }
        return false;
    } 
    
        public boolean verificadorAereo(Integer trayectoId){
        Trayecto trayecto = classData.findATById(trayectoId);
        List<Trayecto> trayectosAereos = getTrayectosAereos();
        for(Trayecto actual:trayectosAereos){
            if(actual.getId().equals(trayecto.getId())){
                return true;
            }
        }
        return false;
    } 
}
