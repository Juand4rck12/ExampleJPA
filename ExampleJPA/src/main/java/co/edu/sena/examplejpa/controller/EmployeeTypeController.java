package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Implementar la interface para controlar el modelo EmployeeType
 */

public class EmployeeTypeController implements IEmployeeTypeController {

    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("El tipo de empleado es nulo");
        }
        
        if ("".equals(employeeType.getDescript())) {
            throw new Exception("La descripción es obligatoria");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if (employeeType == null) {
            throw new Exception("El tipo de empleado es nulo");
        }
        
        if (employeeType.getId() == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        if ("".equals(employeeType.getDescript())) {
            throw new Exception("La descripción es obligatoria");
        }
        
        // Consultar si el employeeType existe en la db
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(employeeType.getId());
        if (employeeTypeExists == null) {
            throw new Exception("El tipo de empleado no existe");
        }
        
        // Merge: Todos los campos menos la FK
        employeeTypeExists.setDescript(employeeType.getDescript());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        // Consultar si el employeeType existe en la db
        EmployeeType employeeTypeExists = DAOFactory.getEmployeeTypeDAO().findById(id);
        if (employeeTypeExists == null) {
            throw new Exception("No existe el empleado");
        }
        
        // Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return DAOFactory.getEmployeeTypeDAO().findAll();
    }

    @Override
    public EmployeeType findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        return DAOFactory.getEmployeeTypeDAO().findById(id);
    }
    
}
