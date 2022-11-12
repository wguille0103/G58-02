/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Usuario;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Wilman Parra
 */
public interface IUsuarioService {
    
    public List<Usuario> findAll();

    public Page<Usuario> findAll(Pageable pageable);

    public Usuario findById(Integer id);

    public Usuario save(Usuario cliente);

    public void delete(Integer id);
    
}
