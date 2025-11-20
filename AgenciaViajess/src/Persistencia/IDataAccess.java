/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;

/**
 *
 * @author DELL
 */

public interface IDataAccess<T> {
    T findById(Integer id);
    List<T> findAll();
    void save(T item);
    void delete(Integer id);
}
