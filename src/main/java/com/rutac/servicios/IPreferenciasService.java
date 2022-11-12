/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Preferencias;
import com.rutac.modelo.TipoPreferencia;
import java.util.List;

/**
 *
 * @author Wilman Parra
 */
public interface IPreferenciasService {
    
    public List<Preferencias> findAll();
    
    public List<TipoPreferencia> tipoPreferenciasfindAll();
    
    public Preferencias save(Preferencias preferencias);
    
    public List<Preferencias> listarPreferenciasPorUsuario(Integer idUsuario);
   
    
}
