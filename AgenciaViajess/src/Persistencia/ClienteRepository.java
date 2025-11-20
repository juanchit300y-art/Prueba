
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelos.Cliente;

public class ClienteRepository extends GeneralRepository<Cliente> {
    
    public ClienteRepository() {
        this.dataAccess = new JsonRepository<>("clientes.json", Cliente.class);
    }
    public ClienteRepository(IDataAccess<Cliente> dataAccess) {
        this.dataAccess = dataAccess;
    }
   
}