/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.controladores;

import com.rutac.modelo.Preferencias;
import com.rutac.modelo.TipoPreferencia;
import com.rutac.servicios.IPreferenciasService;
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
@RequestMapping("/preferencias")
public class PreferenciasController {
    
    @Autowired
    private IPreferenciasService preferenciasService;

 /*   @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Preferencias> list() {
        return preferenciasService.findAll();
    }*/
    
    @GetMapping("/tipoPreferencia")
    @ResponseStatus(HttpStatus.OK)
    public List<TipoPreferencia> listTipoPreferencias() {
        return preferenciasService.tipoPreferenciasfindAll();
    }
    
    @PostMapping("/guardar")
    public Preferencias save(@RequestBody Preferencias preferencias){
    return preferenciasService.save(preferencias);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Preferencias> listarPreferenciasPorUsuario(@PathVariable int  id) {
        return preferenciasService.listarPreferenciasPorUsuario(id);
    }
}
