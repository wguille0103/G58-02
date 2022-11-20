package com.backend.rutac.Service;

import com.backend.rutac.Dao.RutaDao;
import com.backend.rutac.Models.Ruta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class RutaService {

    @Autowired
    private RutaDao rutaDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Ruta save(Ruta ruta) {
        return rutaDao.save(ruta);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        rutaDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Ruta findById(Integer id) {
        return rutaDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Ruta> findAll() {
        return (List<Ruta>) rutaDao.findAll();
    }

}
