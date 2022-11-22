package com.backend.rutac.Controller;

import com.backend.rutac.Models.Vehiculo;
import com.backend.rutac.Service.VehiculoService;

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
@RequestMapping("/vehiculo")
public class VehiculoController {

  //@Autowired
  //private VehiculoDao dao;
  @Autowired
  private VehiculoService vehiculoService;

  //Método Post para Insertar datos en la tabla de la BD
  @PostMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Vehiculo> agregar(@RequestBody Vehiculo dato) {

    Vehiculo obj = vehiculoService.save(dato);
    return new ResponseEntity<>(obj, HttpStatus.OK);     
  }

  //Método Delete para Eliminar datos en la tabla de la BD
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Vehiculo> eliminar(@PathVariable Integer id) {

    Vehiculo obj = vehiculoService.findById(id);
    if (obj != null) { //Encontró al registro
      vehiculoService.delete(id);
    } 
    else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);

  }

  //Método Put para Modificar datos en la tabla de la BD
  @PutMapping(value = "/")
  @ResponseBody
  public ResponseEntity<Vehiculo> editar(@RequestBody Vehiculo dato) {
    Vehiculo obj = vehiculoService.findById(dato.getCodigo_veh());
    if (obj != null) { //Lo encotró
      obj.setColor_veh(dato.getColor_veh());
      obj.setFoto_veh(dato.getFoto_veh());
      obj.setModelo_veh(dato.getModelo_veh());
      obj.setMarca_veh(dato.getMarca_veh());
      obj.setPlaca_veh(dato.getPlaca_veh());
      obj.setTipo_veh(dato.getTipo_veh());
      vehiculoService.save(dato);
    } else {
      return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(obj, HttpStatus.OK);
  }

//Método Put para Modificar datos en la tabla de la BD
    @GetMapping("/list") 
    @ResponseBody
    public List<Vehiculo> consultarTodo(){
        
        return vehiculoService.findAll();
          
    }
    
    @GetMapping("/list/{id}") 
    @ResponseBody
    public Vehiculo consultaPorId(@PathVariable Integer id){ 
        return vehiculoService.findById(id); 
    }
    
   
    

}