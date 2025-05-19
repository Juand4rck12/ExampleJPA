package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo tipo de empleado
 */
public class EmployeeTypeDAO implements IEmployeeTypeDAO {

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(EmployeeType employeeType) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(employeeType);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public EmployeeType findById(Integer id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(EmployeeType.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        try {
            String name = "EmployeeType.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
