/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 *
 * @author Wilman Parra
 */
@Entity
@Table(name = "municipio")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
    @NamedQuery(name = "Municipio.findByCodMunicipio", query = "SELECT m FROM Municipio m WHERE m.codMunicipio = :codMunicipio"),
    @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "cod_municipio")
    private Integer codMunicipio;
    @Basic(optional = false)
    
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @OneToOne(optional = false)
    private Departamento codDepartamento;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMunicipio")
    private List<Usuario> usuarioList;*/

    public Municipio() {
    }

    public Municipio(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Municipio(Integer codMunicipio, String nombre) {
        this.codMunicipio = codMunicipio;
        this.nombre = nombre;
    }

    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Departamento codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

   /* public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMunicipio != null ? codMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.codMunicipio == null && other.codMunicipio != null) || (this.codMunicipio != null && !this.codMunicipio.equals(other.codMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutac.modelo.Municipio[ codMunicipio=" + codMunicipio + " ]";
    }
    
}
