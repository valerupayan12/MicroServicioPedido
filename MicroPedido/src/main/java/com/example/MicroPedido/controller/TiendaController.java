package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroPedido.dto.TiendaDTO;
import com.example.MicroPedido.service.TiendaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    // LISTAR TODAS
    @GetMapping
    public List<TiendaDTO.Response> listarTiendas() {
        return tiendaService.listarTiendas();
    }

    // BUSCAR POR ID
    @GetMapping("{id_tienda}")
    public TiendaDTO.Response buscarTienda(@PathVariable int id_tienda) {
        return tiendaService.buscarTienda(id_tienda);
    }

    // CREAR
    @PostMapping
    public TiendaDTO.Response guardarTienda(
            @Valid @RequestBody TiendaDTO.Request request) {

        return tiendaService.guardarTienda(request);
    }

    // ACTUALIZAR
    @PutMapping("{id_tienda}")
    public TiendaDTO.Response actualizarTienda(
            @PathVariable int id_tienda,
            @Valid @RequestBody TiendaDTO.Request request) {

        return tiendaService.actualizarTienda(id_tienda, request);
    }

    // ELIMINAR
    @DeleteMapping("{id_tienda}")
    public String eliminarTienda(@PathVariable int id_tienda) {

        if (tiendaService.eliminarTienda(id_tienda) == 1) {
            return "Tienda eliminada correctamente";
        }

        return "Error al eliminar tienda";
    }
}