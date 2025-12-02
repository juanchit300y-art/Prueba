/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Persistencia.IDataAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import Modelos.Carro;
public class JsonRepository<T> implements IDataAccess<T>{
    private String filename;
    private Gson gson;
    private Type listType;
    private Class<T> clazz;
    
    public JsonRepository(String filename, Class<T> clazz) {
        this.filename = filename;
        this.clazz = clazz;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.listType = TypeToken.getParameterized(ArrayList.class, clazz).getType();
    }
    
    private List<T> readFromFile() {
        try (Reader reader = new FileReader(filename)) {
            List<T> items = gson.fromJson(reader, listType);
            return items != null ? items : new ArrayList<T>();
        } catch (FileNotFoundException e) {
            return new ArrayList<T>();
        } catch (IOException e) {
            System.err.println("Horror leyendo archivo: " + e.getMessage());
            return new ArrayList<T>();
        }
    }
    
    private void writeToFile(List<T> items) {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.err.println("Horror escribiendo archivo: " + e.getMessage());
        }
    }
    private Integer getNextIdSeleccion(List<T> items) {
       int i= 0;
       Integer respuesta;
       T actual= items.get(i);
        if( actual instanceof Carro ){
             respuesta= getNextIdCarro( items);
        }
        else{
            respuesta= getNextId(items);
        }
        return respuesta;
    }
    private Integer getNextIdCarro(List<T> items) {
        Integer maxId = 1000;
        for (T item : items) {
            try {
                java.lang.reflect.Method getIdMethod = item.getClass().getMethod("getId");
                Integer currentId = (Integer) getIdMethod.invoke(item);
                if (currentId != null && currentId > maxId) {
                    maxId = currentId;
                }
            } catch (Exception e) {
                System.err.println("Horror obteniendo ID: " + e.getMessage());
            }
        }
        return maxId + 1;
    }
    private Integer getNextId(List<T> items) {
        Integer maxId = 0;
        for (T item : items) {
            try {
                java.lang.reflect.Method getIdMethod = item.getClass().getMethod("getId");
                Integer currentId = (Integer) getIdMethod.invoke(item);
                if (currentId != null && currentId > maxId) {
                    maxId = currentId;
                }
            } catch (Exception e) {
                System.err.println("Horror obteniendo ID: " + e.getMessage());
            }
        }
        return maxId + 1;
    }
    
    @Override
    public T findById(Integer id) {
        List<T> items = readFromFile();
        for (T item : items) {
            try {
                java.lang.reflect.Method getIdMethod = item.getClass().getMethod("getId");
                Integer currentId = (Integer) getIdMethod.invoke(item);
                if (currentId != null && currentId.equals(id)) {
                    return item;
                }
            } catch (Exception e) {
                System.err.println("Horror encontrando objeto: " + e.getMessage());
            }
        }
        return null;
    }
    
    @Override
    public List<T> findAll() {
        return readFromFile();
    }
    
    @Override
    public void save(T item) {
        List<T> items = readFromFile();
        try {
            java.lang.reflect.Method getIdMethod = item.getClass().getMethod("getId");
            Integer id = (Integer) getIdMethod.invoke(item);
            
            if (id == null) {
                // New item - assign ID
                id = getNextIdSeleccion(items);
                java.lang.reflect.Method setIdMethod = item.getClass().getMethod("setId", Integer.class);
                setIdMethod.invoke(item, id);
                items.add(item);
            } else {
                // Existing item - find and replace
                boolean found = false;
                for (int i = 0; i < items.size(); i++) {
                    T existingItem = items.get(i);
                    Integer existingId = (Integer) getIdMethod.invoke(existingItem);
                    if (id.equals(existingId)) {
                        items.set(i, item);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    items.add(item);
                }
            }
            writeToFile(items);
        } catch (Exception e) {
            System.err.println("Clase que falló: " + item.getClass().getName());
            e.printStackTrace();
        }
    }
    
    @Override
    public void delete(Integer id) {
        List<T> items = readFromFile();
        try {
            for (int i = 0; i < items.size(); i++) {
                T item = items.get(i);
                java.lang.reflect.Method getIdMethod = item.getClass().getMethod("getId");
                Integer currentId = (Integer) getIdMethod.invoke(item);
                if (id.equals(currentId)) {
                    items.remove(i);
                    break;
                }
            }
            writeToFile(items);
        } catch (Exception e) {
            System.err.println("Horror eliminando objeto: " + e.getMessage());
        }
    }
}

