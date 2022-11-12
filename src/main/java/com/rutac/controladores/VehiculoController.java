/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.controladores;

import com.rutac.modelo.Vehiculo;
import com.rutac.servicios.IVehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vehiculo> listarVehiculosPorUsuario(@PathVariable int  id) {
        return vehiculoService.listarVehiculosPorUsuario(id);
    }
    
    @PostMapping("/guardar")
    public Vehiculo save(@RequestBody Vehiculo vehiculo){
    return vehiculoService.save(vehiculo);
    }
    
}
