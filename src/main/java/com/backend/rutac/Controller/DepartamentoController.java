package com.backend.rutac.Controller;

import com.backend.rutac.Models.Departamento;
import com.backend.rutac.Service.DepartamentoService;

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
@RequestMapping("/departamento")
public class DepartamentoController {

  //@Autowired
  //private DepartamentoDao dao;
  @Autowired
  private DepartamentoService departamentoService;

  //Método Post para Insertar departamentos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Departamento> agregar(@RequestBody Departamento departamento) {

    Departamento obj = departamentoService.save(departamento);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar departamentos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Departamento> eliminar(@PathVariable Integer id) {

    Departamento obj = departamentoService.findById(id);
    if (obj != null) { //Encontró al registro
      departamentoService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar departamentos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Departamento> editar(@RequestBody Departamento departamento) {
    Departamento obj = departamentoService.findById(departamento.getCodigo_dep());
    if (obj != null) { //Lo encotró
      obj.setNombre_dep(departamento.getNombre_dep());
      departamentoService.save(departamento);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar departamentos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Departamento> consultarTodo(){
        
        return departamentoService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Departamento consultaPorId(@PathVariable Integer id){ 
        return departamentoService.findById(id); 
    }
    
   
    

}

