package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroPedido.model.DetallePedido;
import com.example.MicroPedido.service.DetallePedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/detalle_pedidos")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    // LISTAR TODOS
    @GetMapping
    public List<DetallePedido> listarDetallePedidos() {
        return detallePedidoService.getDetallesPedido();
    }

    // AGREGAR
    @PostMapping
    public DetallePedido agregarDetallePedido(@Valid @RequestBody DetallePedido detallePedido) {
        return detallePedidoService.saveDetallePedido(detallePedido);
    }

    // BUSCAR
    @GetMapping("{id_detalle}")
    public DetallePedido buscarDetallePedido(@PathVariable int id_detalle) {
        return detallePedidoService.getDetallePedidoById(id_detalle);
    }

    // ACTUALIZAR
    @PutMapping("{id_detalle}")
    public int actualizarDetallePedido(@PathVariable int id_detalle,
            @Valid @RequestBody DetallePedido detallePedido) {
        detallePedido.setId_detalle(id_detalle);
        return detallePedidoService.updateDetallePedido(detallePedido);
    }

    // ELIMINAR
    @DeleteMapping("{id_detalle}")
    public String eliminarDetallePedido(@PathVariable int id_detalle) {
        if (detallePedidoService.deleteDetallePedido(id_detalle) == 1) {
            return "Detalle pedido eliminado correctamente";
        }
        return "Error al eliminar el detalle del pedido";
    }
}