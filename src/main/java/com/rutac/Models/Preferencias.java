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
@Table(name="preferencias")
public class Preferencias implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="codigo_pre")
    private int codigo_pre;
    @Column(name="documento_usu")
    private String documento_usu;
    @Column(name="ide_tipo_ref")
    private int ide_tipo_ref;
    @Column(name="estado_pre")
    private Boolean estado_pre;
    @Override
    public String toString() {
      return "Preferencias [codigo_pre=" + codigo_pre + ", documento_usu=" + documento_usu + ", ide_tipo_ref="
          + ide_tipo_ref + ", estado_pre=" + estado_pre + "]";
    }

    


    }
    

