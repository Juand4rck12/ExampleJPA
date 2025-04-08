package co.edu.sena.examplejpa.persistence;

import java.util.List;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: interface para DAO de Record
 */
public interface IRecordDAO {
    public void insert(Record record) throws Exception;
    public void update(Record record) throws Exception;
    public void delete(Record record) throws Exception;
    public Record findById(Integer id) throws Exception;
    public List<Record> findAll() throws Exception;
}
