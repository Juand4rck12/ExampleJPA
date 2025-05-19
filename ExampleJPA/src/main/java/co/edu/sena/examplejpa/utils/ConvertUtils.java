package co.edu.sena.examplejpa.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Fecha: 03/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: clase para utileria de mensajes en pantalla
 */

public class ConvertUtils {
    
    public static String dateToString (Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = dateFormat.format(date);
        return result;
    }
    
    public static Date stringToDate (String text) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
        return date;
    }
    
    /**
     * Convierte una hora en un String
     * @param date
     * @return 
     */
    public static String timeToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String result = dateFormat.format(date);
        return result;
    }
    
    /**
     * Convierte un String en una hora
     * @param text
     * @return
     * @throws ParseException 
     */
    public static Date StringToTime(String text) throws ParseException {
        Date date = new SimpleDateFormat("HH:mm").parse(text);
        return date;
    }
    
    /**
     * Convertir de LocalDate a Date
     * @param localDate
     * @return 
     */
    public static Date localDateToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Convierte LocalTime a Date
     * @param localTime
     * @return 
     */
    public static Date localTimeToDate(LocalTime localTime) {
        return Date.from(LocalDate.now()
                                        .atTime(localTime)
                                        .atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * convierte de date a LocalDate
     * @param date
     * @return 
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
