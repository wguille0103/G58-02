package com.backend.rutac.Dao;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;

import com.backend.rutac.Models.Municipio;

public interface MunicipioDao extends CrudRepository<Municipio,Integer> {

}