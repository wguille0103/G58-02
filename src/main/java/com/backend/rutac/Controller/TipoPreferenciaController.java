package com.backend.rutac.Controller;

import com.backend.rutac.Models.TipoPreferencia;
import com.backend.rutac.Service.TipoPreferenciaService;

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
@RequestMapping("/tipopreferencia")
public class TipoPreferenciaController {

  //@Autowired
  //private TipoPreferenciaDao dao;
  @Autowired
  private TipoPreferenciaService tipopreferenciaService;

  //Método Post para Insertar departamentos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<TipoPreferencia> agregar(@RequestBody TipoPreferencia tipopreferencia) {

    TipoPreferencia obj = tipopreferenciaService.save(tipopreferencia);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar departamentos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<TipoPreferencia> eliminar(@PathVariable Integer id) {

    TipoPreferencia obj = tipopreferenciaService.findById(id);
    if (obj != null) { //Encontró al registro
      tipopreferenciaService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar departamentos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<TipoPreferencia> editar(@RequestBody TipoPreferencia tipopreferencia) {
    TipoPreferencia obj = tipopreferenciaService.findById(tipopreferencia.getIde_tipo_ref());
    if (obj != null) { //Lo encotró
      obj.setNombre_tipo_ref(tipopreferencia.getNombre_tipo_ref());
      obj.setDescripcion_tipo_ref(tipopreferencia.getDescripcion_tipo_ref());
      tipopreferenciaService.save(tipopreferencia);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar departamentos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<TipoPreferencia> consultarTodo(){
        
        return tipopreferenciaService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public TipoPreferencia consultaPorId(@PathVariable Integer id){ 
        return tipopreferenciaService.findById(id); 
    }
    
   
    

}

