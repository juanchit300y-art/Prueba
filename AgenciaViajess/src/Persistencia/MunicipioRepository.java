/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Municipio;

public class MunicipioRepository extends GeneralRepository<Municipio>{
    
    
    public MunicipioRepository() {
        this.dataAccess = new JsonRepository<>("Municipios.json", Municipio.class);
    }
    public MunicipioRepository(IDataAccess<Municipio> dataAccess) {
        this.dataAccess = dataAccess;
    }
}