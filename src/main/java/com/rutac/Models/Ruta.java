package com.rutac.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//Para validar los errores
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;




@Getter
@Setter
@Entity
@Table(name="ruta")
public class Ruta implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    //@NotEmpty(message = "El campo identificador del  vehículo no debe ser vacío")
    @Column(name="codigo_rut")
    //Estas validaciones también se deben relacionar en los post y put del controllador.
    private int codigo_rut;
    //@NotEmpty(message = "El campo código vehículo no debe ser vacío")
    //@Size(min = 4, max = 20,message = "El campo código Vehículo debe tener mínimo 4 caracteres y máximo 20")
    @Column(name="nombre_conductor")
    private String nombre_conductor;
    //@NotEmpty(message = "El campo modelo vehículo no debe ser vacío")
    //@Size(min = 5, max = 80,message = "El campo modelo Vehículo debe tener mínimo 5 caracteres y máximo 50")
    @ManyToOne
    @JoinColumn(name="codigo_veh")
    private Vehiculo codigo_veh;
    //@NotEmpty(message = "El campo tipo Vehículo no debe ser vacío")
    //@Size(min = 5, max = 50,message = "El campo tipo Vehículo debe tener mínimo 5 caracteres y máximo 50")
    @Column(name="estado_rut")
    private int estado_rut;
    //@NotEmpty(message = "El campo color Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo color Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="punto_partida")
    private String punto_partida;
    //@NotEmpty(message = "El campo marca Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo marca Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="fecha_rut")
    private Calendar fecha_rut;
    //@NotEmpty(message = "El campo placa Vehículo no debe ser vacío")
    //@Size(min = 3, max = 15,message = "El campo marca Vehículo debe tener mínimo 3 caracteres y máximo 15")
    @Column(name="punto_destino")
    private String punto_destino;
    //@NotEmpty(message = "El campo foto Vehículo no debe ser vacío")
    @Column(name="cupos_rut")
    private int cupos_rut;
    @Column(name="indicacion_origen")
    private String indicacion_origen;
    @Column(name="indicacion_llegada")
    private String indicacion_llegada;
    @Column(name="valor_cupo")
    private int valor_cupo;
    @ManyToOne
    @JoinColumn(name="documento_usu")
    private Usuario documento_usu;
    @Override
    public String toString() {
      return "Ruta [codigo_rut=" + codigo_rut + ", nombre_conductor=" + nombre_conductor + ", codigo_veh=" + codigo_veh
          + ", estado_rut=" + estado_rut + ", punto_partida=" + punto_partida + ", fecha_rut=" + fecha_rut
          + ", punto_destino=" + punto_destino + ", cupos_rut=" + cupos_rut + ", indicacion_origen=" + indicacion_origen
          + ", indicacion_llegada=" + indicacion_llegada + ", valor_cupo=" + valor_cupo + ", documento_usu="
          + documento_usu + "]";
    }
 



   
}
