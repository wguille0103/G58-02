/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.controladores;

import com.rutac.modelo.Usuario;
import com.rutac.servicios.IUsuarioService;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
//@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> list() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/page/{page}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Usuario> index(@PathVariable Integer page) {
        Pageable pageable = (Pageable) PageRequest.of(page, 4);
        return usuarioService.findAll(pageable);
    }
    
    @PostMapping("/guardar")
    public Usuario save(@RequestBody Usuario usuario){
    return usuarioService.save(usuario);
    }
    
}
