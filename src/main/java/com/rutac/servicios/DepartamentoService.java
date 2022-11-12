/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Departamento;
import com.rutac.repositorio.DepartamentoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Parra
 */
@Service
public class DepartamentoService implements IDepartamentoService{
    
    @Autowired
    private DepartamentoDao departamentoRepository;

    @Override
    public List<Departamento> findAll() {
        return (List<Departamento>) departamentoRepository.findAll();
    }
    
    
    
}
