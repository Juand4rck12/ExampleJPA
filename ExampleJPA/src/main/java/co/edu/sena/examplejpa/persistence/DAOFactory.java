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

    public static IEmployeeTypeDAO getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public static IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static IKeyRoomDAO getKeyRoomDAO() {
        return keyRoomDAO;
    }

    public static IRecordDAO getRecordDAO() {
        return recordDAO;
    }
        
}
