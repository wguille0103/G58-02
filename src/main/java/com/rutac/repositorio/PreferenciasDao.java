/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.repositorio;

import com.rutac.modelo.Preferencias;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Wilman Parra
 */
public interface PreferenciasDao extends JpaRepository<Preferencias, Id> {
    
    @Query("select p from Preferencias p inner join p.idUsuario u where u.id = :idUsuario")
    public List<Preferencias> listarPreferenciasPorUsuario(Integer idUsuario);
    
}
