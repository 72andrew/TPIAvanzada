/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrew.tpintegrador.modelo;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    
    @Basic
    private String Nombre;  
    private String Apellido;
    private long telefono;
    private String email;
    private String historialPedido; //aca va a ser una lista
    private String preferencias;

    public Cliente() {
    }

    public Cliente(int id, String Nombre, String Apellido, long telefono, String email, String historialPedido, String preferencias) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.telefono = telefono;
        this.email = email;
        this.historialPedido = historialPedido;
        this.preferencias = preferencias;
    }
    
        public Cliente(String Nombre, String Apellido,long telefono, String email) {
      
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.telefono = telefono;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHistorialPedido() {
        return historialPedido;
    }

    public void setHistorialPedido(String historialPedido) {
        this.historialPedido = historialPedido;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    @Override
    public String toString() {
        return "id=" + id + ", Nom=" + Nombre + ", Ape=" + Apellido + ", tel=" + telefono + ", email=" + email + ", historialPedido=" + historialPedido + ", preferencias=" + preferencias + '\n';
    }
    
    
    
}
