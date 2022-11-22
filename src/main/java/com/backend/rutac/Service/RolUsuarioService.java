package com.backend.rutac.Service;

import com.backend.rutac.Dao.RolUsuarioDao;
import com.backend.rutac.Models.RolUsuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class RolUsuarioService {

    @Autowired
    private RolUsuarioDao rolusuarioDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public RolUsuario save(RolUsuario rolusuario) {
        return rolusuarioDao.save(rolusuario);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        rolusuarioDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public RolUsuario findById(Integer id) {
        return rolusuarioDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<RolUsuario> findAll() {
        return (List<RolUsuario>) rolusuarioDao.findAll();
    }

}

