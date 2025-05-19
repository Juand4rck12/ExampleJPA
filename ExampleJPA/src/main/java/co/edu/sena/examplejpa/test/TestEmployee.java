package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.controller.EmployeeController;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.utils.MessageUtils;
import java.util.List;

/**
 * Fecha: 22/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Probar el controlador de empleado
 */

public class TestEmployee {
    
    public void insert(){
        try {
            
            Employee employee = new Employee(1233L, "Juan Andres", "Cra 24", "315454");
            IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
            EmployeeType type = employeeTypeController.findById(1);
            employee.setTypeId(type); // FK
            IEmployeeController controller = new EmployeeController();
            controller.insert(employee);
            MessageUtils.showInfoMessage("Empleado creado con exito");
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void update(){
        try {
            
            Employee employee = new Employee(1233L, "Juan Andres", "Cra 24 con # 18", "45748415");
            IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
            EmployeeType type = employeeTypeController.findById(2);
            employee.setTypeId(type); // FK
            IEmployeeController controller = new EmployeeController();
            controller.update(employee);
            MessageUtils.showInfoMessage("Empleado actualizado con exito");
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void delete(){
        try {
            IEmployeeController controller = new EmployeeController();
            Employee employee = controller.findById(6793);
            controller.delete(employee.getDocument());
            MessageUtils.showInfoMessage("Empleado eliminado con exito");
            
        } catch (Exception e) {
            MessageUtils.showInfoMessage(e.getMessage());
        }
    }
    
    public void findAll() {
        try {
            IEmployeeController controller = new EmployeeController();
            List<Employee> employees = controller.findAll();
            String message = "";
            for (Employee e : employees) {
                message += "Documento: " + e.getDocument()
                        + "\nNombre: " + e.getFullname()
                        + "\nDirección: " + e.getAddress()
                        + "\nTeléfono: " + e.getPhone()
                        + "\nTipo: " + e.getTypeId().getDescript();
            }
            MessageUtils.showInfoMessage(message);
            
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestEmployee test = new TestEmployee();
        // test.insert();
        // test.update();
        // test.delete();
        test.findAll();
    }
}
