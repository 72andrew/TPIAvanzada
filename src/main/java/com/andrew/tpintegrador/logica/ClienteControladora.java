
package com.andrew.tpintegrador.logica;

import com.andrew.tpintegrador.modelo.Cliente;
import com.andrew.tpintegrador.persistencia.ClienteControladoraPersistencia;
import java.util.ArrayList;

public class ClienteControladora {
    ClienteControladoraPersistencia controlPersis = new ClienteControladoraPersistencia();
    
    public void crearCliente(Cliente cliente){
        controlPersis.crearCliente(cliente);
    }
    
    public void eliminarCliente(int id){
        controlPersis.eliminarCliente(id);
    }
    
    public Cliente traerCliente(int id){
        return controlPersis.traerCliente(id);
    }
    
    public ArrayList<Cliente> traerListaClientes(){
        return controlPersis.listarClientes();
    }
    
    public void editarMailCliente(int id, String mail){
        controlPersis.modificarMailCliente(id, mail);
    }
}
