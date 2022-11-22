package com.rutac.Service;

import com.rutac.Dao.PreferenciasDao;
import com.rutac.Models.Preferencias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class PreferenciasService {

    @Autowired
    private PreferenciasDao preferenciasDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Preferencias save(Preferencias preferencias) {
        return preferenciasDao.save(preferencias);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        preferenciasDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Preferencias findById(Integer id) {
        return preferenciasDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Preferencias> findAll() {
        return (List<Preferencias>) preferenciasDao.findAll();
    }

}

