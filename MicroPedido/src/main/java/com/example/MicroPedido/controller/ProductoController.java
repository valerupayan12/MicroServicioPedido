package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroPedido.dto.ProductoDTO;
import com.example.MicroPedido.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // LISTAR TODOS
    @GetMapping
    public List<ProductoDTO.Response> listarProductos() {
        return productoService.listarTodos();
    }

    // LISTAR ACTIVOS
    @GetMapping("/activos")
    public List<ProductoDTO.Response> listarActivos() {
        return productoService.listarActivos();
    }

    // BUSCAR POR ID
    @GetMapping("{id}")
    public ProductoDTO.Response buscarProducto(@PathVariable int id) {
        return productoService.buscarPorId(id);
    }

    // CREAR
    @PostMapping
    public ProductoDTO.Response crearProducto(
            @Valid @RequestBody ProductoDTO.Request request) {

        return productoService.crear(request);
    }

    // ACTUALIZAR
    @PutMapping("{id}")
    public ProductoDTO.Response actualizarProducto(
            @PathVariable int id,
            @Valid @RequestBody ProductoDTO.Request request) {

        return productoService.actualizar(id, request);
    }

    // ELIMINAR
    @DeleteMapping("{id}")
    public String eliminarProducto(@PathVariable int id) {

        if (productoService.eliminar(id) == 1) {
            return "Producto eliminado correctamente";
        }

        return "Error al eliminar producto";
    }
}