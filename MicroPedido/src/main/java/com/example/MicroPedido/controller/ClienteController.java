package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroPedido.model.Cliente;
import com.example.MicroPedido.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
      @Autowired
    private ClienteService clienteService;

    // LISTAR CLIENTES
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // AGREGAR CLIENTE
    @PostMapping
    public Cliente agregarCliente(@Valid @RequestBody Cliente cliente) {

        return clienteService.saveCliente(cliente);
    }

    // BUSCAR CLIENTE POR ID
    @GetMapping("{id_cliente}")
    public Cliente buscarCliente(@PathVariable int id_cliente) {

        return clienteService.getClienteById(id_cliente);
    }

    // ACTUALIZAR CLIENTE
    @PutMapping("{id_cliente}")
    public int actualizarCliente(@PathVariable int id_cliente,
                                 @Valid @RequestBody Cliente cliente) {

        cliente.setId_cliente(id_cliente);

        return clienteService.updateCliente(cliente);
    }

    // ELIMINAR CLIENTE
    @DeleteMapping("{id_cliente}")
    public String eliminarCliente(@PathVariable int id_cliente) {

        if (clienteService.deleteCliente(id_cliente) == 1) {
            return "Cliente eliminado correctamente";
        }

        return "Error al eliminar el cliente";
    }
}
