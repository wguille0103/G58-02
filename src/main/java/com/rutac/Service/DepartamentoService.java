package com.rutac.Service;

import com.rutac.Dao.DepartamentoDao;
import com.rutac.Models.Departamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoDao departamentoDao;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Departamento save(Departamento departamento) {
        return departamentoDao.save(departamento);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        departamentoDao.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Departamento findById(Integer id) {
        return departamentoDao.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Departamento> findAll() {
        return (List<Departamento>) departamentoDao.findAll();
    }

}

