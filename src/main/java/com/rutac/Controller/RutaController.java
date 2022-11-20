package com.backend.rutac.Controller;

import com.backend.rutac.Models.Ruta;
import com.backend.rutac.Service.RutaService;

import java.util.List;


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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/ruta")
public class RutaController {

  //@Autowired
  //private VehiculoDao dao;
  @Autowired
  private RutaService rutaService;

  //Método Post para Insertar datos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Ruta> agregar(@RequestBody Ruta dato) {

    Ruta obj = rutaService.save(dato);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar datos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Ruta> eliminar(@PathVariable Integer id) {

    Ruta obj = rutaService.findById(id);
    if (obj != null) {//Encontró al registro
      rutaService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar datos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Ruta> editar(@RequestBody Ruta dato) {
    Ruta obj = rutaService.findById(dato.getCodigo_rut());
    if (obj != null) { //Lo encotró
      obj.setNombre_conductor(dato.getNombre_conductor());
      obj.setCodigo_veh(dato.getCodigo_veh());
      obj.setEstado_rut(dato.getEstado_rut());
      obj.setPunto_partida(dato.getPunto_partida());
      obj.setPunto_destino(dato.getPunto_destino());
      obj.setCupos_rut(dato.getCupos_rut());
      obj.setIndicacion_origen(dato.getIndicacion_origen());
      obj.setIndicacion_llegada(dato.getIndicacion_llegada());
      obj.setValor_cupo(dato.getValor_cupo());
      obj.setDocumento_usu(dato.getDocumento_usu());

      rutaService.save(dato);
    } else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar datos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Ruta> consultarTodo(){
        
        return rutaService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Ruta consultaPorId(@PathVariable Integer id){ 
        return rutaService.findById(id); 
    }
    
   
}