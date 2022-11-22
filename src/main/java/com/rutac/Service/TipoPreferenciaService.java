package com.rutac.Service;

import com.rutac.Dao.TipoPreferenciaDao;
import com.rutac.Models.TipoPreferencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class TipoPreferenciaService {

    @Autowired
    private TipoPreferenciaDao tipopreferenciaDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public TipoPreferencia save(TipoPreferencia tipopreferencia) {
        return tipopreferenciaDao.save(tipopreferencia);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        tipopreferenciaDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public TipoPreferencia findById(Integer id) {
        return tipopreferenciaDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<TipoPreferencia> findAll() {
        return (List<TipoPreferencia>) tipopreferenciaDao.findAll();
    }

}

