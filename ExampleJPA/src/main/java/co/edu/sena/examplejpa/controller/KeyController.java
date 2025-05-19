package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;

import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Juan Diego Orrego Vargas
 * Objetivo: Implementar la interface para controlar el modelo Key
 */

public class KeyController implements IKeyRoomController {

    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if (keyRoom == null) {
            throw new Exception("La llave es nula");
        }
        
        if (keyRoom.getId() == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        if ("".equals(keyRoom.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(keyRoom.getRoom())) {
            throw new Exception("El room es obligatorio");
        }
        
        if (keyRoom.getCount() < 1) {
            throw new Exception("El número de llaves es obligatorio");
        }
        
        // Insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if (keyRoom == null) {
            throw new Exception("La llave es nula");
        }
        
        if (keyRoom.getId() == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        if ("".equals(keyRoom.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        if ("".equals(keyRoom.getRoom())) {
            throw new Exception("El room es obligatorio");
        }
        
        if (keyRoom.getCount() < 1) {
            throw new Exception("El número de llaves es obligatorio");
        }
        
        // Consultar si la key existe en la db
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(keyRoom.getId());
        if (keyExists == null) {
            throw new Exception("La llave no existe");
        }
        
        // Actualizar
        keyExists.setCount(keyRoom.getCount());
        keyExists.setName(keyRoom.getName());
        keyExists.setRoom(keyRoom.getRoom());
        keyExists.setObservation(keyRoom.getObservation());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        // Consultar si la llave existe en la db
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(id);
        if (keyExists == null) {
            throw new Exception("No existe la llave");
        }

        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().findAll();
    }

    @Override
    public KeyRoom findById(int id) throws Exception {
        if (id == 0) {
            throw new Exception("El Id es obligatorio");
        }
        
        return DAOFactory.getKeyRoomDAO().findById(id);
    }
    
}
