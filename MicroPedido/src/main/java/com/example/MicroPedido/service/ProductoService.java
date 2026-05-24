package com.example.MicroPedido.service;

import java.util.List;

import com.example.MicroPedido.dto.ProductoDTO;

public interface ProductoService {
    List<ProductoDTO.Response> listarTodos();
    List<ProductoDTO.Response> listarPorCategoria(String categoria);
    List<ProductoDTO.Response> listarActivos();
    ProductoDTO.Response buscarPorId(Long id);
    ProductoDTO.Response crear(ProductoDTO.Request request);
    ProductoDTO.Response actualizar(Long id, ProductoDTO.Request request);
    void eliminar(Long id);
}
