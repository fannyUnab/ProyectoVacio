/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.p7.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fannycc
 */
@Entity
@Table(name = "comprarproducto")
@NamedQueries({
    @NamedQuery(name = "Comprarproducto.findAll", query = "SELECT c FROM Comprarproducto c"),
    @NamedQuery(name = "Comprarproducto.findById", query = "SELECT c FROM Comprarproducto c WHERE c.id = :id"),
    @NamedQuery(name = "Comprarproducto.findByProductoId", query = "SELECT c FROM Comprarproducto c WHERE c.productoId = :productoId"),
    @NamedQuery(name = "Comprarproducto.findByCompraId", query = "SELECT c FROM Comprarproducto c WHERE c.compraId = :compraId"),
    @NamedQuery(name = "Comprarproducto.findByValor", query = "SELECT c FROM Comprarproducto c WHERE c.valor = :valor")})
public class Comprarproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "producto_id")
    private Integer productoId;
    @Column(name = "compra_id")
    private Integer compraId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;

    public Comprarproducto() {
    }

    public Comprarproducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
        if (!(object instanceof Comprarproducto)) {
            return false;
        }
        Comprarproducto other = (Comprarproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.api.p7.Models.Comprarproducto[ id=" + id + " ]";
    }
    
}
