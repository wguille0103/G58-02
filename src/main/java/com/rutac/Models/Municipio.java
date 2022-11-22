package com.rutac.Models;

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
@Table(name="municipio")
public class Municipio implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="codigo_mun")
    private int codigo_mun;
    @Column(name="nombre_mun")
    private String nombre_mun;

    @Column(name = "codigo_dep")
    public Departamento codigo_dep;

    @Override
    public String toString() {
      return "Municipio [codigo_mun=" + codigo_mun + ", nombre_mun=" + nombre_mun + ", codigo_dep=" + codigo_dep + "]";
    }



    }
    

