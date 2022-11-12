/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Rol;
import com.rutac.modelo.RolUsuario;
import java.util.List;

/**
 *
 * @author Wilman Parra
 */
public interface IRolService {
    
    public List<Rol> findAll();
    
    public RolUsuario save(RolUsuario rolUsuario);
    
}
