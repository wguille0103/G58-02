package com.backend.rutac.Controller;

import com.backend.rutac.Models.RolUsuario;
import com.backend.rutac.Service.RolUsuarioService;

import java.util.List;

//import javax.validation.Valid;
//import javax.validation.constraints.Null;

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
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/rolusuario")
public class RolUsuarioController {

  //@Autowired
  //private RolUsuarioDao dao;
  @Autowired
  private RolUsuarioService rolusuarioService;

  //Método Post para Insertar departamentos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<RolUsuario> agregar(@RequestBody RolUsuario rolusuario) {

    RolUsuario obj = rolusuarioService.save(rolusuario);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar departamentos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<RolUsuario> eliminar(@PathVariable Integer id) {

    RolUsuario obj = rolusuarioService.findById(id);
    if (obj != null) { //Encontró al registro
      rolusuarioService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar departamentos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<RolUsuario> editar(@RequestBody RolUsuario rolusuario) {
    RolUsuario obj = rolusuarioService.findById(rolusuario.getIde_rol_usu());
    if (obj != null) { //Lo encotró
      obj.setIde_rol(rolusuario.getIde_rol());
      obj.setDocumento_usu(rolusuario.getDocumento_usu());
      rolusuarioService.save(rolusuario);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar departamentos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<RolUsuario> consultarTodo(){
        
        return rolusuarioService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public RolUsuario consultaPorId(@PathVariable Integer id){ 
        return rolusuarioService.findById(id); 
    }
    
   
    

}

