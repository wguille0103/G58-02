package com.rutac.Dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;

import com.rutac.Models.Rol;

public interface RolDao extends CrudRepository<Rol,Integer> {

}