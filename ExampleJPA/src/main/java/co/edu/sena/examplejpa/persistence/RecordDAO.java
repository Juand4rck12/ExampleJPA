package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Record;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de Record
 */
public class RecordDAO implements IRecordDAO {

    @Override
    public void insert(Record record) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Record record) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Record record) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(record);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Record findById(int id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Record.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Record> findAll() throws Exception {
        try {
            String name = "Record.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
