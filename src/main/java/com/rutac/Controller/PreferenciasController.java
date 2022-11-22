package com.rutac.Controller;

import com.rutac.Models.Preferencias;
import com.rutac.Service.PreferenciasService;

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
@RequestMapping("/preferencias")
public class PreferenciasController {

  //@Autowired
  //private PreferenciasDao dao;
  @Autowired
  private PreferenciasService preferenciasService;

  //Método Post para Insertar departamentos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Preferencias> agregar(@RequestBody Preferencias preferencias) {

    Preferencias obj = preferenciasService.save(preferencias);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar departamentos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Preferencias> eliminar(@PathVariable Integer id) {

    Preferencias obj = preferenciasService.findById(id);
    if (obj != null) { //Encontró al registro
      preferenciasService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar departamentos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Preferencias> editar(@RequestBody Preferencias preferencias) {
    Preferencias obj = preferenciasService.findById(preferencias.getCodigo_pre());
    if (obj != null) { //Lo encotró
      obj.setDocumento_usu(preferencias.getDocumento_usu());
      obj.setIde_tipo_ref(preferencias.getIde_tipo_ref());
      obj.setEstado_pre(preferencias.getEstado_pre());
      preferenciasService.save(preferencias);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar departamentos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Preferencias> consultarTodo(){
        
        return preferenciasService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Preferencias consultaPorId(@PathVariable Integer id){ 
        return preferenciasService.findById(id); 
    }
    
   
    

}

