/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Aerolinea;
import java.util.List;
import java.util.ArrayList;

public class AerolineaRepository extends GeneralRepository<Aerolinea>{
    
    public AerolineaRepository() {
        this.dataAccess = new JsonRepository<>("aerolineas.json", Aerolinea.class);
    }
    public AerolineaRepository(IDataAccess<Aerolinea> dataAccess) {
        this.dataAccess = dataAccess;
    }
}