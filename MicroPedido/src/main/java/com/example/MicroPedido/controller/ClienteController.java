package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroPedido.dto.ClienteDTO;
import com.example.MicroPedido.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO.Response>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO.Response> crearCliente(
            @Valid @RequestBody ClienteDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.crearCliente(request));
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<ClienteDTO.Response> buscarPorId(
            @PathVariable int id_cliente) {
        return ResponseEntity.ok(clienteService.buscarPorId(id_cliente));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ClienteDTO.Response> buscarPorNombre(
            @PathVariable String nombre) {
        return ResponseEntity.ok(clienteService.buscarPorNombre(nombre));
    }

    @PutMapping("/{id_cliente}")
    public ResponseEntity<ClienteDTO.Response> actualizarCliente(
            @PathVariable int id_cliente,
            @Valid @RequestBody ClienteDTO.Request request) {
        return ResponseEntity.ok(clienteService.actualizarCliente(id_cliente, request));
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<String> eliminarCliente(@PathVariable int id_cliente) {
        clienteService.eliminarCliente(id_cliente);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}