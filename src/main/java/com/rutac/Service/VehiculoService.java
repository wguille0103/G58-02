package com.backend.rutac.Service;

import com.backend.rutac.Dao.VehiculoDao;
import com.backend.rutac.Models.Vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;


@Service
public class VehiculoService {

    @Autowired
    private VehiculoDao vehiculoService;
    
    //Creamos el método para Guardar datos en la Tabla de la BD
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoService.save(vehiculo);
    }


    //Creamos el método para Eliminar datos en la Tabla de la BD
    @Transactional(readOnly=false)
    public void delete(Integer id) {
        vehiculoService.deleteById(id);
    }


    //Creamos el método para buscar un solo registro en la Tabla de la BD
    @Transactional(readOnly=true)
    public Vehiculo findById(Integer id) {
        return vehiculoService.findById(id).orElse(null);
    }


    //Creamos el método para buscar todos los registros en la Tabla de la BD
    @Transactional(readOnly=true)
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) vehiculoService.findAll();
    }

}
