package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * Fecha: 22/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Probar el controlador de tipo de empleado
 */

public class TestEmployeeType {

    public void insert() {
        try {
            EmployeeType employeeType = new EmployeeType();
            employeeType.setDescript("NUEVO TIPO");
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.insert(employeeType);

        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void update() {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(13);
            employeeType.setDescript("NUEVO TIPO ACTUALIZADO");
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.insert(employeeType);
            MessageUtils.showInfoMessage("TIPO DE EMPLEADO MODIFICADO CON EXITO");

        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void delete() {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(13);
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.delete(employeeType.getId());
            MessageUtils.showInfoMessage("TIPO DE EMPLEADO ELIMINADO CON EXITO");

        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void findAll() {
        try {
            IEmployeeTypeController controller = new EmployeeTypeController();
            List<EmployeeType> types = controller.findAll();
            String message = "";
            for (EmployeeType type : types) {
                message += "id: " + type.getId() + "\nDescripción: " + type.getDescript() + "\n";
            }
            MessageUtils.showInfoMessage(message);
            
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }

    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
        // test.insert();
        // test.update();
        // test.delete();
        test.findAll();
    }
}
