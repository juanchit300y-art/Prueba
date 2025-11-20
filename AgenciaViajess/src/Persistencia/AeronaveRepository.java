/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Aeronave;
import java.util.ArrayList;
import java.util.List;

public class AeronaveRepository extends GeneralRepository<Aeronave> {    
    public AeronaveRepository() {
        this.dataAccess = new JsonRepository<>("aeronaves.json", Aeronave.class);
    }
    public AeronaveRepository(IDataAccess<Aeronave> dataAccess) {
        this.dataAccess = dataAccess;
    }
    public List<Aeronave> findActividadesTuristicasByAerolineaId(Integer AerolineaId) {
        List<Aeronave> aeronaves = getAllT();
        List<Aeronave> result = new ArrayList<>();
        for (Aeronave aeronave : aeronaves) {
            if (aeronave.getIdAerolinea() != null && aeronave.getIdAerolinea().equals(AerolineaId)) {
                result.add(aeronave);
            }
        }
        return result;
    }
    
}