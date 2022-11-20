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
@Table(name="tipo_preferencia")
public class TipoPreferencia implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="ide_tipo_ref")
    private int ide_tipo_ref;
    @Column(name="nombre_tipo_ref")
    private String nombre_tipo_ref;
    @Column(name="descripcion_tipo_ref")
    private String descripcion_tipo_ref;

    @Override
    public String toString() {
      return "TipoPreferencia [ide_tipo_ref=" + ide_tipo_ref + ", nombre_tipo_ref=" + nombre_tipo_ref
          + ", descripcion_tipo_ref=" + descripcion_tipo_ref + "]";
    }
    
    }
    

