package com.backend.rutac.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//Para validar los errores
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table(name="rol")
public class Rol implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="ide_rol")
    private int ide_rol;
    @Column(name="nombre_rol")
    private String nombre_rol;

    @Override
    public String toString() {
      return "Rol [ide_rol=" + ide_rol + ", nombre_rol=" + nombre_rol + "]";
    }
    
    }
    

