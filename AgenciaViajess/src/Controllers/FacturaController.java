/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.*;
import Modelos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author DELL
 */
public class FacturaController extends GeneralController<Factura> {
    private ViajeRepository viajeData;
    private ClienteRepository clienteData;
    private FacturaRepository facturaData;
    private ItinerarioTransporteController controladorItinerario;
    private EntretenimientoController controladorEntretenimiento;
    private PlanRepository planRepository;
    private ActividadTuristicaRepository actividadTuristicaRepository;
    private PlanController planController;
    private ElementoPlanRepository elementoPlanData;
    private EntretenimientoRepository entretenimientoData;
    public FacturaController() {
        this.classData= new FacturaRepository();
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorItinerario= new ItinerarioTransporteController();
        this.controladorEntretenimiento= new EntretenimientoController();
        this.planRepository = new PlanRepository();
        this.actividadTuristicaRepository = new ActividadTuristicaRepository();
        this.planController = new PlanController();
        this.elementoPlanData = new ElementoPlanRepository();
        this.entretenimientoData = new EntretenimientoRepository();
    }
    public FacturaController(FacturaRepository classData) {
        this.classData= classData;
        this.viajeData= new ViajeRepository();
        this.clienteData= new ClienteRepository();
        this.facturaData= new FacturaRepository();
        this.controladorItinerario= new ItinerarioTransporteController();
        this.planRepository = new PlanRepository();
        this.actividadTuristicaRepository = new ActividadTuristicaRepository();
        this.planController = new PlanController();
        this.elementoPlanData = new ElementoPlanRepository();
        this.entretenimientoData = new EntretenimientoRepository();
    }
    @Override
    public boolean eliminarObjeto(Integer id) {
        classData.deleteT(id);
        return true;
    }    
    
    public boolean actualizarFactura(Integer id,Integer costo,  Integer viajeId, Integer clienteId) {
        Factura factura = classData.findATById(id);
        if (factura == null) {
            return false;
        }
        if (costo != null && costo<0) {
            factura.setCosto(costo);
        }
        if (viajeId != null) {
            Viaje viaje = viajeData.findATById(viajeId);
            if (viaje == null) {
                return false;
            }
            factura.setViajeId(viajeId);
        }
        if(clienteId!= null){
            Cliente cliente= clienteData.findATById(clienteId);
            if(cliente== null){
                return false;
            }
            factura.setClienteId(clienteId);
        }        
        classData.saveT(factura);
        return true;
    }

    public boolean añadirFactura(Integer costo, Integer viajeId, Integer clienteId) {
        if (costo == null || costo<1) {
            return false;
        }
        Viaje viaje = viajeData.findATById(viajeId);
        if (viaje == null) {
            return false;
        }
        Cliente cliente = clienteData.findATById(clienteId);
        if (cliente == null) {
            return false;
        }
        Factura factura = new Factura();
        factura.setCosto(costo);
        factura.setViajeId(viajeId);
        factura.setClienteId(clienteId);
        
        classData.saveT(factura);
        return true;
    }
    //Cliente relacion (caso curso)
    public List<Factura> getFacturasByCliente(Integer clienteId) {
        return facturaData.findFacturasByClienteId(clienteId);
    }
    public Cliente getClienteDeFactura(Integer facturaId) {
        Factura factura = classData.findATById(facturaId);
        if (factura == null) {
            return null;
        }
        return clienteData.findATById(factura.getClienteId());
    }
    //Viaje relacion (caso curso)    
    public List<Factura> getFacturasByViaje(Integer viajeId) {
        return facturaData.findFacturasByViajeId(viajeId);
    }
    public Viaje getViajeDeFactura(Integer facturaId) {
        Factura factura = classData.findATById(facturaId);
        if (factura == null) {
            return null;
        }
        return viajeData.findATById(factura.getViajeId());
    }
    //Metodo D
    public Double metodoD(Integer idCliente){
        Double respuesta=0.0;
        List<Factura> facturasXCliente= getFacturasByCliente(idCliente);
        for(Factura actual : facturasXCliente){
            Integer viajeId= actual.getViajeId();
            Double sumar= controladorItinerario.costoTrayectoXViaje(viajeId);
            respuesta= sumar + respuesta;
        }
        return respuesta;
    }
    // Metodo H
    public int metodoH(Integer idAerolinea, Integer idMunicipio){
        int respuesta=0;
        List<Cliente> clientes= clienteData.getAllT();
        for(Cliente actual2 : clientes){ 
            Integer idCliente= actual2.getId();
            List<Factura> facturasXCliente= getFacturasByCliente(idCliente);
            for(Factura actual : facturasXCliente){
                Integer viajeId= actual.getViajeId();
                boolean resultado1= controladorItinerario.revisionViajeAerolinea(viajeId, idAerolinea);
                boolean resultado2= controladorEntretenimiento.verificadorIdMunicipioH(viajeId, idMunicipio);
                if(resultado1 && resultado2 ){
                    respuesta++;
                }
            }
        }
        return respuesta;
    }
    //Metodo F LO HIZO CHAT
    public Double metodoF(){
        Double respuesta;
        double cantViajes1=0;
        double numTrayectos=0;
        List<Cliente> clientes= clienteData.getAllT();
        for(Cliente actual: clientes){
            Integer idClienteActual= actual.getId();
            List<Factura> facturasCliente= getFacturasByCliente(idClienteActual);
            int cantiViajes= facturasCliente.size();
            cantViajes1 = (double)cantiViajes;
            if(cantiViajes > 1){
                for(Factura actual2 : facturasCliente){
                    Integer idViaje= actual2.getViajeId();
                    int promedio= controladorItinerario.numTrayectosF(idViaje);
                    numTrayectos= promedio + numTrayectos;
                }
                
            }
        }
        respuesta= numTrayectos/cantViajes1;
        return respuesta;
    }
    

    
    // En FacturaController o en ConsultaService (donde tengas acceso a todos los repositorios)
public List<Plan> metodoJ(Integer actividadId) {
    List<Plan> resultado = new ArrayList<>();

    if (actividadId == null) return resultado;

    // Cargar todos los datos que necesitamos (usar repositorios compartidos)
    List<Factura> facturas = facturaData.getAllT();
    List<Entretenimiento> entretenimientos = entretenimientoData.getAllT();
    List<ElementoPlan> elementosPlan = elementoPlanData.getAllT();
    List<Plan> planes = planRepository.getAllT();

    // 1) Identificar clientes con >1 viajes (por facturas)
    // Mapa clienteId -> set de viajeIds
    Map<Integer, Set<Integer>> viajesPorCliente = new HashMap<>();
    for (Factura f : facturas) {
        Integer cId = f.getClienteId();
        Integer vId = f.getViajeId();
        if (cId == null || vId == null) continue;
        Set<Integer> s = viajesPorCliente.get(cId);
        if (s == null) {
            s = new HashSet<>();
            viajesPorCliente.put(cId, s);
        }
        s.add(vId);
    }

    // 2) Construir set de viajes contratados por clientes con >1 viaje
    Set<Integer> viajesClientesMas1 = new HashSet<>();
    for (Map.Entry<Integer, Set<Integer>> e : viajesPorCliente.entrySet()) {
        if (e.getValue().size() > 1) {
            viajesClientesMas1.addAll(e.getValue());
        }
    }

    if (viajesClientesMas1.isEmpty()) return resultado; // no hay clientes con >1 viaje

    // 3) Para cada entretenimiento de esos viajes, obtener el plan
    Set<Integer> planesEncontrados = new HashSet<>();
    for (Entretenimiento ent : entretenimientos) {
        if (ent == null) continue;
        Integer viajeId = ent.getViajeId();
        Integer planId = ent.getPlanId();
        if (viajesClientesMas1.contains(viajeId) && planId != null) {
            // comprobamos si ese plan incluye la actividadId
            // buscamos elementos del plan en elementosPlan
            for (ElementoPlan ep : elementosPlan) {
                if (ep != null && ep.getPlanId() != null && ep.getActividadTuristicaId() != null) {
                    if (ep.getPlanId().equals(planId) && ep.getActividadTuristicaId().equals(actividadId)) {
                        planesEncontrados.add(planId);
                        break; // ya sabemos que ese plan incluye la actividad
                    }
                }
            }
        }
    }

    // 4) Convertir planIds a Plan objects
    for (Plan p : planes) {
        if (p != null && p.getId() != null && planesEncontrados.contains(p.getId())) {
            resultado.add(p);
        }
    }

    return resultado;
}

}