/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.controladores;

import com.rutac.modelo.Departamento;
import com.rutac.servicios.IDepartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Wilman Parra
 */
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    
    @Autowired
    private IDepartamentoService depatamentoService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Departamento> list() {
        return depatamentoService.findAll();
    }
    
}
