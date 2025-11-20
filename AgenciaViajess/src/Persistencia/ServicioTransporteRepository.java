/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.ServicioTransporte;
import java.util.ArrayList;
import java.util.List;

public class ServicioTransporteRepository extends GeneralRepository<ServicioTransporte>{
    
    
    public ServicioTransporteRepository() {
        this.dataAccess = new JsonRepository<>("ServiciosDeTransporte.json", ServicioTransporte.class);
    }
    public ServicioTransporteRepository(IDataAccess<ServicioTransporte> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<ServicioTransporte> findServicioTransporteByTrayectoId(Integer trayectoId) {
        List<ServicioTransporte> servicioTransportes = getAllT();
        List<ServicioTransporte> result = new ArrayList<>();
        for (ServicioTransporte servicioTransporte : servicioTransportes) {
            if (servicioTransporte.getTrayectoId() != null && servicioTransporte.getTrayectoId().equals(trayectoId)) {
                result.add(servicioTransporte);
            }
        }
        return result;
    }
    public List<ServicioTransporte> findServicioTransporteByVehiculoId(Integer vehiculoId) {
        List<ServicioTransporte> servicioTransportes = getAllT();
        List<ServicioTransporte> result = new ArrayList<>();
        for (ServicioTransporte servicioTransporte : servicioTransportes) {
            if (servicioTransporte.getVehiculoId() != null && servicioTransporte.getVehiculoId().equals(vehiculoId)) {
                result.add(servicioTransporte);
            }
        }
        return result;
    }
    //algo
}