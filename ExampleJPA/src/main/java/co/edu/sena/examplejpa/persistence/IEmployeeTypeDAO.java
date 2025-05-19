package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: interface para DAO de tipo de empleado
 */
public interface IEmployeeTypeDAO {
    public void insert (EmployeeType employeeType) throws Exception;
    public void update (EmployeeType employeeType) throws Exception;
    public void delete (EmployeeType employeeType) throws Exception;
    public EmployeeType findById(Integer id) throws Exception;
    public List<EmployeeType> findAll() throws Exception;
}
