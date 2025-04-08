package co.edu.sena.examplejpa.persistence;

/**
 * Fecha: 08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: instanciar los DAO's creados en la persistencia
 */
public class DAOFactory {
    private static IEmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
    private static IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static IKeyRoomDAO keyRoomDAO = new KeyRoomDAO();
    private static IRecordDAO recordDAO = new RecordDAO();
}
