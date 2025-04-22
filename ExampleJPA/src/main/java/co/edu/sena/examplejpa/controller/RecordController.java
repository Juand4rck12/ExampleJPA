package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Implementar la interface para controlar el modelo Record
 */

public class RecordController implements IRecordController {
    

    @Override
    public void insert(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El registro es nulo");
        }
        
        if (record.getDateRecord() == null) {
            throw new Exception("La fecha es obligatoria");
        }
        
        if (record.getStartTime() == null) {
            throw new Exception("El inicio es obligatio");
        }
        
        // FK empleado
        if (record.getEmployeeId() == null ) {
            throw new Exception("El Id de empleado es obligatorio");
        }
        
        // FK key
        if (record.getKeyId() == null) {
            throw new Exception("El Id de llave es obligatorio");
        }
        
        if ("".equals(record.getStatus())) {
            throw new Exception("El estado es obligatorio");
        }
        
        Record recordExists = DAOFactory.getRecordDAO().findById(record.getId());
        if (recordExists != null) {
            throw new Exception("El Id del registro ya existe");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El registro es nulo");
        }

        if (record.getDateRecord() == null) {
            throw new Exception("La fecha es obligatoria");
        }

        if (record.getStartTime() == null) {
            throw new Exception("El inicio es obligatio");
        }
        
        // FK empleado
        if (record.getEmployeeId() == null ) {
            throw new Exception("El Id de empleado es obligatorio");
        }
        
        // FK key
        if (record.getKeyId() == null) {
            throw new Exception("El Id de llave es obligatorio");
        }
        
        if ("".equals(record.getStatus())) {
            throw new Exception("El estado es obligatorio");
        }

        record.setDateRecord(record.getDateRecord());
        record.setStartTime(record.getStartTime());
        record.setEndTime(record.getEndTime());
        record.setStatus(record.getStatus());
        record.setEmployeeId(record.getEmployeeId());
        record.setKeyId(record.getKeyId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if (recordExists == null) {
            throw new Exception("No existe el registro");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Record> findAll() throws Exception {
        return DAOFactory.getRecordDAO().findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        return DAOFactory.getRecordDAO().findById(id);
    }
    
}
