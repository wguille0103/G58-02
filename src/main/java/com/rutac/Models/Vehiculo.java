package com.backend.rutac.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Para validar los errores
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    //@NotEmpty(message = "El campo identificador del  vehículo no debe ser vacío")
    @Column(name="codigo_veh")
    //Estas validaciones también se deben relacionar en los post y put del controllador.
    private int codigo_veh;
    //@NotEmpty(message = "El campo código vehículo no debe ser vacío")
    //@Size(min = 4, max = 20,message = "El campo código Vehículo debe tener mínimo 4 caracteres y máximo 20")
    @Column(name="modelo_veh")
    private String modelo_veh;
    //@NotEmpty(message = "El campo modelo vehículo no debe ser vacío")
    //@Size(min = 5, max = 80,message = "El campo modelo Vehículo debe tener mínimo 5 caracteres y máximo 50")
    @Column(name="tipo_veh")
    private String tipo_veh;
    //@NotEmpty(message = "El campo tipo Vehículo no debe ser vacío")
    //@Size(min = 5, max = 50,message = "El campo tipo Vehículo debe tener mínimo 5 caracteres y máximo 50")
    @Column(name="color_veh")
    private String color_veh;
    //@NotEmpty(message = "El campo color Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo color Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="marca_veh")
    private String marca_veh;
    //@NotEmpty(message = "El campo marca Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo marca Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="placa_veh")
    private String placa_veh;
    //@NotEmpty(message = "El campo placa Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo marca Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="foto_veh")
    private String foto_veh;
    //@NotEmpty(message = "El campo foto Vehículo no debe ser vacío")
    
    @Override
    public String toString() {
      return "Vehiculo [codigo_veh=" + codigo_veh + ", modelo_veh=" + modelo_veh + ", tipo_veh=" + tipo_veh
          + ", color_veh=" + color_veh + ", marca_veh=" + marca_veh + ", placa_veh=" + placa_veh + ", foto_veh="
          + foto_veh + "]";
    }
    




    

   
}
