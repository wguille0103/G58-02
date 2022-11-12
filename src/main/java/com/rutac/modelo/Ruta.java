/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rutac.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Wilman Parra
 */
@Entity
@Table(name = "ruta")
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findById", query = "SELECT r FROM Ruta r WHERE r.id = :id"),
    @NamedQuery(name = "Ruta.findByEstadoRuta", query = "SELECT r FROM Ruta r WHERE r.estadoRuta = :estadoRuta"),
    @NamedQuery(name = "Ruta.findByFecha", query = "SELECT r FROM Ruta r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Ruta.findByNumeroCupos", query = "SELECT r FROM Ruta r WHERE r.numeroCupos = :numeroCupos"),
    @NamedQuery(name = "Ruta.findByIndicacionOrigen", query = "SELECT r FROM Ruta r WHERE r.indicacionOrigen = :indicacionOrigen"),
    @NamedQuery(name = "Ruta.findByIndicacionLlegada", query = "SELECT r FROM Ruta r WHERE r.indicacionLlegada = :indicacionLlegada"),
    @NamedQuery(name = "Ruta.findByValorCupo", query = "SELECT r FROM Ruta r WHERE r.valorCupo = :valorCupo")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    
    @Column(name = "estado_ruta")
    private short estadoRuta;
    @Basic(optional = false)
   
    @Lob
    @Column(name = "punto_partida")
    private byte[] puntoPartida;
    @Basic(optional = false)
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
   
    @Lob
    @Column(name = "punto_destino")
    private byte[] puntoDestino;
    @Basic(optional = false)
   
    @Column(name = "numero_cupos")
    private int numeroCupos;
    @Basic(optional = false)
    
    @Column(name = "indicacion_origen")
    private String indicacionOrigen;
    @Basic(optional = false)
    
    @Column(name = "indicacion_llegada")
    private String indicacionLlegada;
   
    @Column(name = "valor_cupo")
    private String valorCupo;
    @JoinColumn(name = "id_conductor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idConductor;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehiculo idVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRuta")
    private List<Reserva> reservaList;

    public Ruta() {
    }

    public Ruta(Integer id) {
        this.id = id;
    }

    public Ruta(Integer id, short estadoRuta, byte[] puntoPartida, Date fecha, byte[] puntoDestino, int numeroCupos, String indicacionOrigen, String indicacionLlegada) {
        this.id = id;
        this.estadoRuta = estadoRuta;
        this.puntoPartida = puntoPartida;
        this.fecha = fecha;
        this.puntoDestino = puntoDestino;
        this.numeroCupos = numeroCupos;
        this.indicacionOrigen = indicacionOrigen;
        this.indicacionLlegada = indicacionLlegada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getEstadoRuta() {
        return estadoRuta;
    }

    public void setEstadoRuta(short estadoRuta) {
        this.estadoRuta = estadoRuta;
    }

    public byte[] getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(byte[] puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte[] getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(byte[] puntoDestino) {
        this.puntoDestino = puntoDestino;
    }

    public int getNumeroCupos() {
        return numeroCupos;
    }

    public void setNumeroCupos(int numeroCupos) {
        this.numeroCupos = numeroCupos;
    }

    public String getIndicacionOrigen() {
        return indicacionOrigen;
    }

    public void setIndicacionOrigen(String indicacionOrigen) {
        this.indicacionOrigen = indicacionOrigen;
    }

    public String getIndicacionLlegada() {
        return indicacionLlegada;
    }

    public void setIndicacionLlegada(String indicacionLlegada) {
        this.indicacionLlegada = indicacionLlegada;
    }

    public String getValorCupo() {
        return valorCupo;
    }

    public void setValorCupo(String valorCupo) {
        this.valorCupo = valorCupo;
    }

    public Usuario getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Usuario idConductor) {
        this.idConductor = idConductor;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
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
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rutac.modelo.Ruta[ id=" + id + " ]";
    }
    
}
