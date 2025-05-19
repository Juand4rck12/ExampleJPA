package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Juan Diego
 * Objetivo: interface para el modelo Employee
 */

public interface IEmployeeController {
    public void insert(Employee employee) throws Exception; 
    
    public void update(Employee employee) throws Exception;
    
    public void delete (long document) throws Exception;
    
    public List<Employee> findAll() throws Exception;
    
    public Employee findById(long document) throws Exception;
}
