package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Juan Diego
 * Objetivo: interface para el modelo Record
 */

public interface IRecordController {
    public void insert(Record record) throws Exception;
    
    public void update(Record record) throws Exception;
    
    public void delete (int id) throws Exception;
    
    public List<Record> findAll() throws Exception;
    
    public Record findById(int id) throws Exception;
}
