package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Juan Diego
 * Objetivo: interface para el modelo EmployeeType
 */

public interface IEmployeeTypeController {
    public void insert (EmployeeType employeeType) throws Exception;
    
    public void update (EmployeeType employeeType) throws Exception;
    
    public void delete (int id) throws Exception;
    
    public List<EmployeeType> findAll() throws Exception;
    
    public EmployeeType findById(int id) throws Exception;
}
