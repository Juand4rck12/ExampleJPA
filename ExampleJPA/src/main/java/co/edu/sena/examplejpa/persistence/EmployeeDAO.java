package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Employee;
import java.util.List;
import javax.persistence.Query;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: implementar DAO para modelo de empleado
 */
public class EmployeeDAO implements IEmployeeDAO {

    @Override
    public void insert(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(employee);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void update(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(employee);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public void delete(Employee employee) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(employee);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Employee findById(Long document) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Employee.class, document);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try {
            String name = "Employee.findAll";
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery(name);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw e;
        }
    }
    
}
