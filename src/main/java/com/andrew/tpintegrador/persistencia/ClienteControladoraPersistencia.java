/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrew.tpintegrador.persistencia;

import com.andrew.tpintegrador.modelo.Cliente;
import com.andrew.tpintegrador.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ClienteControladoraPersistencia {

    ClienteJpaController clienJPA = new ClienteJpaController();
    
    public void crearCliente(Cliente cliente) {
       clienJPA.create(cliente);
    }

    public void eliminarCliente(int id) {
        try {
            clienJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClienteControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificarMailCliente(int id,String mail){
        Cliente cliente = traerCliente(id);
        cliente.setEmail(mail);
        try {
            clienJPA.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente traerCliente(int id) {
        return clienJPA.findCliente(id);
    }

    public ArrayList<Cliente> listarClientes() {
        List<Cliente> clienteList = clienJPA.findClienteEntities();
        ArrayList<Cliente> clienteArray = new ArrayList<Cliente>(clienteList);
        return clienteArray;
    }
    
}
