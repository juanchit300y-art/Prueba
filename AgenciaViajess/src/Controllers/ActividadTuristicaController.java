/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.ActividadTuristicaRepository;
import Modelos.ActividadTuristica;
/**
 *
 * @author DELL
 */
public class ActividadTuristicaController extends GeneralController<ActividadTuristica> {

    public ActividadTuristicaController() {
    }
    public ActividadTuristicaController(ActividadTuristicaRepository classData) {
        this.classData= new ActividadTuristicaRepository();
    }

    @Override
    public boolean actualizarObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean añadirObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
