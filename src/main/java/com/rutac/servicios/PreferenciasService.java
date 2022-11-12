/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Preferencias;
import com.rutac.modelo.TipoPreferencia;
import com.rutac.repositorio.PreferenciasDao;
import com.rutac.repositorio.TipoPreferenciasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Parra
 */
@Service
public class PreferenciasService implements IPreferenciasService{
    
    @Autowired
    private PreferenciasDao preferenciasRepository;
    
    @Autowired
    private TipoPreferenciasDao tipoPreferenciasRepository;


    @Override
    public List<Preferencias> findAll() {
        return (List<Preferencias>) preferenciasRepository.findAll();
    }

    @Override
    public List<TipoPreferencia> tipoPreferenciasfindAll() {
        return (List<TipoPreferencia>) tipoPreferenciasRepository.findAll();
    }
    
    @Override
    public Preferencias save(Preferencias preferencias) {
        return preferenciasRepository.save(preferencias);
    }
    
    @Override
    public List<Preferencias> listarPreferenciasPorUsuario(Integer idUsuario) {
        return preferenciasRepository.listarPreferenciasPorUsuario(idUsuario);     
    }
    
}
