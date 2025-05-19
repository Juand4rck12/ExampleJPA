package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 * Fecha:08/04/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: interface para DAO de keyRoom
 */
public interface IKeyRoomDAO {
    public void insert(KeyRoom keyRoom) throws Exception;
    public void update(KeyRoom keyRoom) throws Exception;
    public void delete(KeyRoom keyRoom) throws Exception;
    public KeyRoom findById(Integer id) throws Exception;
    public List<KeyRoom> findAll() throws Exception;
}
