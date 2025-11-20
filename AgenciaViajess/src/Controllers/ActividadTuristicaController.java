/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Persistencia.ActividadTuristicaRepository;
/**
 *
 * @author DELL
 */
public class ActividadTuristicaController extends GeneralController {

    public ActividadTuristicaController() {
    }
    public ActividadTuristicaController(ActividadTuristicaRepository classData) {
        this.classData= new ActividadTuristicaRepository();
    }
    
}
