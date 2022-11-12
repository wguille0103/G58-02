/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Rol;
import com.rutac.modelo.RolUsuario;
import com.rutac.repositorio.RolDao;
import com.rutac.repositorio.RolUsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Parra
 */
@Service
public class RolService implements IRolService {
    
    @Autowired
    private RolDao rolRepository;
    
    @Autowired
    private RolUsuarioDao rolUsuarioRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    
    @Override
    public RolUsuario save(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }
}
