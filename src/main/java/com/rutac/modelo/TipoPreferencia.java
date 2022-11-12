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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author Wilman Parra
 */
@Entity
@Table(name = "tipo_preferencia")
@NamedQueries({
    @NamedQuery(name = "TipoPreferencia.findAll", query = "SELECT t FROM TipoPreferencia t"),
    @NamedQuery(name = "TipoPreferencia.findById", query = "SELECT t FROM TipoPreferencia t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPreferencia.findByNombre", query = "SELECT t FROM TipoPreferencia t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoPreferencia.findByDescripcion", query = "SELECT t FROM TipoPreferencia t WHERE t.descripcion = :descripcion")})
public class TipoPreferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
   
    
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
   
    @Column(name = "descripcion")
    private String descripcion;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPreferencia")
    private List<Preferencias> preferenciasList;*/

    public TipoPreferencia() {
    }

    public TipoPreferencia(Integer id) {
        this.id = id;
    }

    public TipoPreferencia(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   /* public List<Preferencias> getPreferenciasList() {
        return preferenciasList;
    }

    public void setPreferenciasList(List<Preferencias> preferenciasList) {
        this.preferenciasList = preferenciasList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPreferencia)) {
            return false;
        }
        TipoPreferencia other = (TipoPreferencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutac.modelo.TipoPreferencia[ id=" + id + " ]";
    }
    
}
