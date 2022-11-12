/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Vehiculo;
import com.rutac.repositorio.VehiculoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Parra
 */
@Service
public class VehiculoService implements IVehiculoService{
    
    @Autowired
    private VehiculoDao vehiculoRepository;
    

    @Override
    public List<Vehiculo> listarVehiculosPorUsuario(Integer idUsuario) {
        return vehiculoRepository.listarVehiculosPorUsuario(idUsuario);
    }
    
    @Override
    public Vehiculo save(Vehiculo cliente) {
        return vehiculoRepository.save(cliente);
    }
}
