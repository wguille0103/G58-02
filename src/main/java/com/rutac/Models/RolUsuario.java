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
@Table(name="rol_usuario")
public class RolUsuario implements Serializable {
    //Creamos los atributos de la clase de acuerdo a los
    //Campos de la tabla en la BD
    @Id
    @Column(name="ide_rol_usu")
    private int ide_rol_usu;
    @Column(name="ide_rol")
    private Rol ide_rol;
    @Column(name="documento_usu")
    private Usuario documento_usu;
    @Override
    public String toString() {
      return "RolUsuario [ide_rol_usu=" + ide_rol_usu + ", ide_rol=" + ide_rol + ", documento_usu=" + documento_usu
          + "]";
    }
    

    }
    

