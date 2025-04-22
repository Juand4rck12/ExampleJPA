package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Implementar la interface para controlar el modelo Employee
 */

public class EmployeeController implements IEmployeeController {

    @Override
    public void insert(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0) {
            throw new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getAddress())) {
            throw new Exception("La dirección es obligatoria");
        }
        
        if ("".equals(employee.getPhone())) {
            throw new Exception("El teléfono es obligatorio");
        }
        
        // FK
        if (employee.getTypeId() == null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        // La FK no es autoincremental, se debe validar existencia del empleado
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists != null) {
            throw new Exception("Ya existe un empleado con ese documento");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().insert(employee);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void update(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("El empleado es nulo");
        }
        
        if (employee.getDocument() == 0) {
            throw new Exception("El documento es obligatorio");
        }
        
        if ("".equals(employee.getFullname())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(employee.getAddress())) {
            throw new Exception("La dirección es obligatoria");
        }
        
        if ("".equals(employee.getPhone())) {
            throw new Exception("El teléfono es obligatorio");
        }
        
        // FK
        if (employee.getTypeId() == null) {
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(employee.getDocument());
        if (employeeExists == null) {
            throw new Exception("No existe un empleado con ese documento");
        }
        
        // Actualizar
        employeeExists.setFullname(employeeExists.getFullname());
        employeeExists.setAddress(employeeExists.getAddress());
        employeeExists.setPhone(employeeExists.getPhone());
        employeeExists.setTypeId(employeeExists.getTypeId());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().update(employee);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(long document) throws Exception {
        if (document == 0) {
            throw new Exception("El documento es obligatorio");
        }
        
        Employee employeeExists = DAOFactory.getEmployeeDAO().findById(document);
        if (employeeExists == null) {
            throw new Exception("No existe un empleado con ese documento");
        }
            
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeDAO().delete(employeeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Employee> findAll() throws Exception {
        return DAOFactory.getEmployeeDAO().findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if (document == 0) {
            throw new Exception("El documento es obligatorio");
        }
        
        return DAOFactory.getEmployeeDAO().findById(document);
    }
    
}
