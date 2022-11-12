/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.repositorio;

import com.rutac.modelo.Municipio;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Wilman Parra
 */
public interface MunicipioDao extends JpaRepository<Municipio, Id>{
    
    @Query("select m from Municipio m inner join m.codDepartamento d where d.id = ?1")
    List<Municipio> listarMunicipiosPorCodDepartamento(Integer idDepartamento);
    
}
