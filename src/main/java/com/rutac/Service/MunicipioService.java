package com.rutac.Service;

import com.rutac.Dao.MunicipioDao;
import com.rutac.Models.Municipio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class MunicipioService {

    @Autowired
    private MunicipioDao dao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Municipio save(Municipio municipio) {
        return dao.save(municipio);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        dao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Municipio findById(Integer id) {
        return dao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Municipio> findAll() {
        return (List<Municipio>) dao.findAll();
    }

}

