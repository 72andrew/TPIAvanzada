/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrew.tpintegrador.modelo;

import java.io.Serializable;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private float valor;
    private String descripcion;
    
    @OneToOne
    private Transportista tranportista;
    @OneToOne
    private Ciudad ciudadOrigen;
    @OneToOne
    private Ciudad ciudadDestino;

    public Pedido() {
    }

    public Pedido(int id, float valor, String descripcion, Transportista tranportista, Ciudad CiudadOrigen, Ciudad Destino) {
        this.id = id;
        this.valor = valor;
        this.descripcion = descripcion;
        this.tranportista = tranportista;
        this.ciudadOrigen = CiudadOrigen;
        this.ciudadDestino = Destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Transportista getTranportista() {
        return tranportista;
    }

    public void setTranportista(Transportista tranportista) {
        this.tranportista = tranportista;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad CiudadOrigen) {
        this.ciudadOrigen = CiudadOrigen;
    }

    public Ciudad getDestino() {
        return ciudadDestino;
    }

    public void setDestino(Ciudad Destino) {
        this.ciudadDestino = Destino;
    }
    
    
    
}
