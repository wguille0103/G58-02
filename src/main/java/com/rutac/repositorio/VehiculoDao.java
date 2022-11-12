/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.repositorio;

import com.rutac.modelo.Vehiculo;
import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Wilman Parra
 */
public interface VehiculoDao extends JpaRepository<Vehiculo, Id> {
    
    @Query("select v from Vehiculo v inner join v.idUsuario u where u.id = :idUsuario")
    public List<Vehiculo> listarVehiculosPorUsuario(Integer idUsuario);
     
    
    
}
