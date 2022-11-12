/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.controladores;

import com.rutac.modelo.Rol;
import com.rutac.modelo.RolUsuario;
import com.rutac.servicios.IRolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Wilman Parra
 */
@RestController
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private IRolService rolService;

    @GetMapping("/tipoRol")    
    @ResponseStatus(HttpStatus.OK)
    public List<Rol> list() {
        return rolService.findAll();
    }
    
     @PostMapping("/guardar")
    public RolUsuario save(@RequestBody RolUsuario rolUsuario){
    return rolService.save(rolUsuario);
    }
    
}
