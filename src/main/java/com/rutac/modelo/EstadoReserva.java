/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 *
 * @author Wilman Parra
 */
@Entity
@Table(name = "estado_reserva")
@NamedQueries({
    @NamedQuery(name = "EstadoReserva.findAll", query = "SELECT e FROM EstadoReserva e"),
    @NamedQuery(name = "EstadoReserva.findById", query = "SELECT e FROM EstadoReserva e WHERE e.id = :id"),
    @NamedQuery(name = "EstadoReserva.findByDescripcion", query = "SELECT e FROM EstadoReserva e WHERE e.descripcion = :descripcion")})
public class EstadoReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
   
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoReserva")
    private List<Reserva> reservaList;

    public EstadoReserva() {
    }

    public EstadoReserva(Integer id) {
        this.id = id;
    }

    public EstadoReserva(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
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
        if (!(object instanceof EstadoReserva)) {
            return false;
        }
        EstadoReserva other = (EstadoReserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutac.modelo.EstadoReserva[ id=" + id + " ]";
    }
    
}
