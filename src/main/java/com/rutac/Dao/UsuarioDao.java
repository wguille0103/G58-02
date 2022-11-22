package com.rutac.Dao;
import com.rutac.Models.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UsuarioDao extends CrudRepository<Usuario,Integer> {
    //Operación de Autentiiicación (SELECT)
    @Transactional(readOnly=true)//No afecta integridad base de datos
    @Query(value="SELECT * FROM usuario WHERE documento_usu= :usuario AND clave_usu= :clave", nativeQuery=true)
    public Usuario login(@Param("usuario") String usuario, @Param("clave") String clave);

   // public Usuario findById(String string); 
  // public Integer deleteByDocumento_usu(String documento);
  @Transactional(readOnly=true)
  @Query("SELECT u FROM Usuario u WHERE u.documento_usu = ?1")
  public List<Usuario> findByDocumentoUsu(String documento);

  //@Transactional(readOnly=true)
  //Borrar por documento WP
  @Modifying
  @Query("DELETE FROM Usuario u WHERE u.documento_usu = ?1")
  public void deleteByDocumentoUsu(String documento);

  //@Modifying
//@Query("delete from Book b where b.title=:title")
//void deleteBooks(@Param("title") String title);
}
