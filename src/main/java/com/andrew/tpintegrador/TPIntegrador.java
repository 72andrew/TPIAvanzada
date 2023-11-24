/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.andrew.tpintegrador;

import com.andrew.tpintegrador.modelo.Cliente;
import com.andrew.tpintegrador.logica.ClienteControladora;
import com.andrew.tpintegrador.logica.Controladora;
import com.andrew.tpintegrador.vista.VistaPrincipal;
import java.util.ArrayList;


/**
 *
 * @author andre
 */
public class TPIntegrador {

    public static void main(String[] args) {
        Controladora control = new Controladora();
        control.iniciar();
        

//Cliente cliente = new Cliente(4, "pedo", "Meier", 33333333, "andreskdc@gmail.com", "jamon", "queso");
        //control.crearCliente(cliente);
        
     //   System.out.println("BUsqueda 1");
       //Cliente cliente1 = control.traerCliente(1);
       // System.out.println(cliente1);
        
        //System.out.println("busqueda 2");
       
       // ArrayList<Cliente> clientes = control.traerListaClientes();

        //for (Cliente cli : clientes) {
       //     System.out.println(cliente1);
       // }
    }
}
