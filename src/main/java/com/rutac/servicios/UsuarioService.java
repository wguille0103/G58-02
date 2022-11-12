/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Usuario;
import com.rutac.repositorio.UsuarioDao;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Wilman Parra
 */
@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private UsuarioDao usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
         return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {    
      return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario cliente) {
        return usuarioRepository.save(cliente);
    }

    @Override
    public void delete(Integer id) {
       usuarioRepository.deleteById(id);
    }
    
    
    
}
