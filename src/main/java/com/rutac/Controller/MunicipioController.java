package com.backend.rutac.Controller;

import com.backend.rutac.Models.Municipio;
import com.backend.rutac.Service.MunicipioService;

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
@RequestMapping("/municipio")
public class MunicipioController {

  //@Autowired
  //private MunicipioDao dao;
  @Autowired
  private MunicipioService municipioService;

  //Método Post para Insertar datos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Municipio> agregar(@RequestBody Municipio dato) {

    Municipio obj = municipioService.save(dato);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar datos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Municipio> eliminar(@PathVariable Integer id) {

    Municipio obj = municipioService.findById(id);
    if (obj != null) { //Encontró al registro
      municipioService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar datos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Municipio> editar(@RequestBody Municipio dato) {
    Municipio obj = municipioService.findById(dato.getCodigo_mun());
    if (obj != null) { //Lo encotró
      obj.setNombre_mun(dato.getNombre_mun());
      obj.setCodigo_dep(dato.getCodigo_dep());
      municipioService.save(dato);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar datos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Municipio> consultarTodo(){
        
        return municipioService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Municipio consultaPorId(@PathVariable Integer id){ 
        return municipioService.findById(id); 
    }
    
   
    

}

