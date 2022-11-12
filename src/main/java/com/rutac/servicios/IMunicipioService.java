/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.servicios;

import com.rutac.modelo.Municipio;
import java.util.List;

/**
 *
 * @author Wilman Parra
 */
public interface IMunicipioService {
   // public Municipio findById(Integer id);
    
    public List<Municipio>listarMunicipiosPorCodDepartamento(Integer id);
}
