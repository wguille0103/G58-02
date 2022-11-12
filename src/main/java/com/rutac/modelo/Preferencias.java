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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Wilman Parra
 */
@Entity
@Table(name = "preferencias")
@NamedQueries({
    @NamedQuery(name = "Preferencias.findAll", query = "SELECT p FROM Preferencias p"),
    @NamedQuery(name = "Preferencias.findById", query = "SELECT p FROM Preferencias p WHERE p.id = :id"),
    @NamedQuery(name = "Preferencias.findByEstado", query = "SELECT p FROM Preferencias p WHERE p.estado = :estado")})
public class Preferencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "id_tipo_preferencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPreferencia idTipoPreferencia;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario idUsuario;

    public Preferencias() {
    }

    public Preferencias(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TipoPreferencia getIdTipoPreferencia() {
        return idTipoPreferencia;
    }

    public void setIdTipoPreferencia(TipoPreferencia idTipoPreferencia) {
        this.idTipoPreferencia = idTipoPreferencia;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencias)) {
            return false;
        }
        Preferencias other = (Preferencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutac.modelo.Preferencias[ id=" + id + " ]";
    }
    
}
