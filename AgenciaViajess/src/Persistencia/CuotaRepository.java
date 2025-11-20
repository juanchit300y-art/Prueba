
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.util.ArrayList;
import java.util.List;

import Modelos.Cuota;

public class CuotaRepository extends GeneralRepository<Cuota> {
    
    public CuotaRepository() {
        this.dataAccess = new JsonRepository<>("cuotas.json", Cuota.class);
    }
    public CuotaRepository(IDataAccess<Cuota> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<Cuota> findCuotasByViajeId(Integer viajeId) {
        List<Cuota> cuotas = getAllT();
        List<Cuota> result = new ArrayList<>();
        for (Cuota cuota : cuotas) {
            if (cuota.getIdViaje() != null && cuota.getIdViaje().equals(viajeId)) {
                result.add(cuota);
            }
        }
        return result;
    }
}