package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 * Fecha: 25/03/2025
 * @author Juan Diego
 * Objetivo: interface para el modelo Key
 */

public interface IKeyRoomController {
    public void insert (KeyRoom key) throws Exception;
    
    public void update (KeyRoom key) throws Exception;
    
    public void delete (int id) throws Exception;
    
    public List<KeyRoom> findAll() throws Exception;
    
    public KeyRoom findById(int id) throws Exception;
}
