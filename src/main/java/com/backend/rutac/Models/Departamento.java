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
@Table(name="departamento")
public class Departamento implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="codigo_dep")
    private int codigo_dep;
    @Column(name="nombre_dep")
    private String nombre_dep;

    @Override
    public String toString() {
      return "Departamento [codigo_dep=" + codigo_dep + ", nombre_dep=" + nombre_dep + "]";
    }
    
    
    }
    

