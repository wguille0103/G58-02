package com.backend.rutac.Controller;

import com.backend.rutac.Models.Rol;
import com.backend.rutac.Service.RolService;

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
@RequestMapping("/rol")
public class RolController {

  //@Autowired
  //private RolDao dao;
  @Autowired
  private RolService rolService;

  //Método Post para Insertar departamentos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Rol> agregar(@RequestBody Rol rol) {

    Rol obj = rolService.save(rol);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar departamentos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Rol> eliminar(@PathVariable Integer id) {

    Rol obj = rolService.findById(id);
    if (obj != null) { //Encontró al registro
      rolService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar departamentos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Rol> editar(@RequestBody Rol rol) {
    Rol obj = rolService.findById(rol.getIde_rol());
    if (obj != null) { //Lo encotró
      obj.setNombre_rol(rol.getNombre_rol());
      rolService.save(rol);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar departamentos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Rol> consultarTodo(){
        
        return rolService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Rol consultaPorId(@PathVariable Integer id){ 
        return rolService.findById(id); 
    }
    
   
    

}

