package com.backend.rutac.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    //Atributos
    @Id
    @Column(name="documento_usu")
    private String documento_usu;
    @Column(name="login_usu")
    private String login_usu;
    @Column(name="email_usu")
    private String email_usu;
    @Column(name="tipo_identificacion_usu")
    private String tipo_identificacion_usu;
    @Column(name="nombre_usu")
    private String nombre_usu;
    @Column(name="apellido_usu")
    private String apellido_usu;
    @Column(name="celular_usu")
    private String celular_usu;
    @ManyToOne
    @JoinColumn(name="codigo_mun")
    private Municipio codigo_mun;   
    @Column(name="genero_usu")
    private String genero_usu;
    @Column(name="foto_usu")
    private String foto_usu;
    @Column(name="estado_usu")
    private Boolean estado_usu;
    @Column(name="clave_usu")
    private String clave_usu;
    @Override
    public String toString() {
      return "Usuario [documento_usu=" + documento_usu + ", login_usu=" + login_usu + ", email_usu=" + email_usu
          + ", tipo_identificacion_usu=" + tipo_identificacion_usu + ", nombre_usu=" + nombre_usu + ", apellido_usu="
          + apellido_usu + ", celular_usu=" + celular_usu + ", codigo_mun=" + codigo_mun + ", genero_usu=" + genero_usu
          + ", foto_usu=" + foto_usu + ", estado_usu=" + estado_usu + ", clave_usu=" + clave_usu + "]";
    }
    
 
    }

    
