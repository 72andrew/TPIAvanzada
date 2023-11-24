/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrew.tpintegrador.logica;

import com.andrew.tpintegrador.modelo.Cliente;
import com.andrew.tpintegrador.vista.ModificarEliminarCliente;
import com.andrew.tpintegrador.vista.VistaCliente;
import com.andrew.tpintegrador.vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class Controladora implements ActionListener {

    private VistaPrincipal vistaPrincipal = new VistaPrincipal();
    private VistaCliente vistaCliente = new VistaCliente();
    private ClienteControladora clienteControl = new ClienteControladora();
    private ModificarEliminarCliente vistaCliEliminar = new ModificarEliminarCliente();

    public Controladora() {
        vistaCliente.jButtonGuardarCliente.setActionCommand("GuardarCliente");
        vistaCliente.jButtonGuardarCliente.addActionListener(this);
        vistaPrincipal.jButton1.setActionCommand("IrCliente");
        vistaPrincipal.jButton1.addActionListener(this);
        vistaCliente.jButton1.setActionCommand("VolverPrincipal");
        vistaCliente.jButton1.addActionListener(this);
        vistaCliEliminar.jButton1.setActionCommand("VolverPrincipal");
        vistaCliEliminar.jButton1.addActionListener(this);
        vistaCliEliminar.jButton2.setActionCommand("IrCliente");
        vistaCliEliminar.jButton2.addActionListener(this);
        vistaCliente.jButton2.setActionCommand("EliminarModCliente");
        vistaCliente.jButton2.addActionListener(this);
        vistaCliEliminar.jButtonActualizar.setActionCommand("EditarCliente");
        vistaCliEliminar.jButtonActualizar.addActionListener(this);
        vistaCliEliminar.jButtonEliminar.setActionCommand("EliminarCliente");
        vistaCliEliminar.jButtonEliminar.addActionListener(this);
        vistaCliEliminar.jButtonTraerTodos.setActionCommand("TodosClientes");
        vistaCliEliminar.jButtonTraerTodos.addActionListener(this);

    }

    public void iniciar() {
        vistaPrincipal.setTitle("TPI");
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }

    public void abrirVistaCliente() {
        vistaCliente.setTitle("Cliente");
        vistaCliente.setVisible(true);
        vistaCliente.setLocationRelativeTo(null);
    }

    public void abrirVistaEliModCliente() {
        vistaCliEliminar.setTitle("Baja o Modificar cliente");
        vistaCliEliminar.setVisible(true);
        vistaCliEliminar.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("GuardarCliente".equals(e.getActionCommand())) {
            Cliente cliente = new Cliente(vistaCliente.jTextNombre.getText(),
                    vistaCliente.jTextApellido.getText(),
                    Long.parseLong(vistaCliente.jTextTelefono.getText()
                    ), vistaCliente.jTextMail.getText());
            clienteControl.crearCliente(cliente);
            System.out.println("guardo un cliente");
        }

        if ("IrCliente".equals(e.getActionCommand())) {
            vistaPrincipal.setVisible(false);
            abrirVistaCliente();
        }

        if ("VolverPrincipal".equals(e.getActionCommand())) {
            vistaCliente.setVisible(false);
            iniciar();
        }

        if ("EliminarModCliente".equals(e.getActionCommand())) {
            vistaCliente.setVisible(false);
            abrirVistaEliModCliente();
        }

        if ("TodosClientes".equals(e.getActionCommand())) {
            vistaCliEliminar.jTextArea1.setText(clienteControl.traerListaClientes().toString());
        }

        if ("EditarCliente".equals(e.getActionCommand())) {
            clienteControl.editarMailCliente(Integer.parseInt(vistaCliEliminar.jTextField1.getText()),
                    vistaCliEliminar.jTextField2.getText());
            vistaCliEliminar.jTextArea1.setText(clienteControl.traerListaClientes().toString());
        }
        
        if("EliminarCliente".equals(e.getActionCommand())){
            clienteControl.eliminarCliente(Integer.parseInt(vistaCliEliminar.jTextField1.getText()));
            vistaCliEliminar.jTextArea1.setText(clienteControl.traerListaClientes().toString());
        }
    }

}
