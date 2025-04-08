package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: interface para DAO de empleado
 */
public interface IEmployeeDAO {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete(Employee employee) throws Exception;
    public Employee findById(Long document) throws Exception;
    public List<Employee> findAll() throws Exception;
}
