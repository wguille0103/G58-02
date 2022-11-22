package com.rutac.Service;
import com.rutac.Models.Usuario;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rutac.Dao.UsuarioDao;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    //Creacion del metodo guardar en la tabla de la bd
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }


    //Creacion del metodo para eliminar datos en la tabla de la bd
    @Transactional(readOnly=false)
    public void delete(String id) {             
       usuarioDao.deleteById(Integer.valueOf(id));       
    }
    
    //Creacion del metodo para buscar un solo registro en la tabla de la bd
    @Transactional(readOnly=true)
    public Usuario findById(String id) {
       return  usuarioDao.findById(Integer.valueOf(id)).orElse(null); 
       // return  usuarioDao.findByDocumento_usu(id);     
    }

    @Transactional(readOnly=true)
    public List<Usuario> findByDocumentoUsu(String id) {
       return  usuarioDao.findByDocumentoUsu(id); 
       // return  usuarioDao.findByDocumento_usu(id);     
    }
    
    //Creacion del metodo para listar todos los registros en la tabla de la bd
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {             
        return  (List<Usuario>) usuarioDao.findAll();     
    }

    @Transactional
    public void deleteByDocumentoUsu(String documento){
        usuarioDao.deleteByDocumentoUsu(documento);
    }
}
