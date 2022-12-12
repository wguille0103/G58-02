package com.backend.rutac.Controller;
import com.backend.rutac.Models.Usuario;
import com.backend.rutac.Security.Hash;
import com.backend.rutac.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
   
    @Autowired
    private UsuarioService servicio;   
   

    @PostMapping(value="/")
    @ResponseBody
    public ResponseEntity<Usuario> guardar(@Valid @RequestBody Usuario dato){       
       dato.setClave_usu(Hash.sha1(dato.getClave_usu()));          
       return new ResponseEntity<>(servicio.save(dato), HttpStatus.OK);
    }            
 

    @GetMapping("/list") 
    @ResponseBody
    public ResponseEntity<List<Usuario>> consultarTodo(){       
      return new ResponseEntity<>(servicio.findAll(),HttpStatus.OK);             
    }

    @GetMapping("/list/{id}") 
    @ResponseBody
    public ResponseEntity<Usuario> consultarPorId(@PathVariable String id){    
      List<Usuario> obj = servicio.findByDocumentoUsu(id); 
      Usuario usuario = obj.get(0);
      usuario.setClave_usu(Hash.getHash(usuario.getClave_usu(), "sha1"));
      //return new ResponseEntity<>(obj.get(0),HttpStatus.OK);
      return new ResponseEntity<>(usuario,HttpStatus.OK);             
    }
   
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Usuario> eliminar(@PathVariable String id) {

   List<Usuario> obj = servicio.findByDocumentoUsu(id);
   if (obj.get(0) != null) { //Encontró al registro
       // servicio.delete(id);
       servicio.deleteByDocumentoUsu(id);
    } 
    else {
      return new ResponseEntity<>(obj.get(0), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj.get(0), HttpStatus.OK);
  }

   //Método Put para Modificar datos en la tabla de la BD
   @PutMapping(value = "/")
   @ResponseBody
   public ResponseEntity<Usuario> editar(@RequestBody Usuario dato) {
    // Usuario obj = servicio.findById(dato.getDocumento_usu());
     List<Usuario> obj = servicio.findByDocumentoUsu(dato.getDocumento_usu());
     if (obj.get(0) != null) { //Lo encotró
    /*/    obj.get(0).setLogin_usu(dato.getLogin_usu());
        obj.get(0).setEmail_usu(dato.getEmail_usu());
        obj.get(0).setTipo_identificacion_usu(dato.getTipo_identificacion_usu())
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu());
        obj.get(0).setCelular_usu(dato.getCelular_usu()); */
     
       servicio.save(dato);
     } else {
       return new ResponseEntity<>(obj.get(0), HttpStatus.INTERNAL_SERVER_ERROR);
     }
     return new ResponseEntity<>(obj.get(0), HttpStatus.OK);
   }

   @GetMapping("/login")
   @ResponseBody
   public Usuario ingresar(@RequestParam ("usuario") String usuario,@RequestParam ("clave") String clave) {
       clave=Hash.sha1(clave);
       return servicio.login(usuario, clave); 
   }
}