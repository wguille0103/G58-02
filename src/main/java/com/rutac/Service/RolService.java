package com.backend.rutac.Service;

import com.backend.rutac.Dao.RolDao;
import com.backend.rutac.Models.Rol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class RolService {

    @Autowired
    private RolDao rolDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

}

