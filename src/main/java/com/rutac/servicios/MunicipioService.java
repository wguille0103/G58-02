/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Municipio;
import com.rutac.repositorio.MunicipioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Wilman Parra
 */
@Service
public class MunicipioService implements IMunicipioService{

    @Autowired
    private MunicipioDao municipioRepository;
    

    @Override
    @Transactional(readOnly = true)
    public List<Municipio> listarMunicipiosPorCodDepartamento(Integer id) {
        return municipioRepository.listarMunicipiosPorCodDepartamento(id);
    }
    
}
