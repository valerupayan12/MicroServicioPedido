package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroPedido.model.CuponDescuento;
import com.example.MicroPedido.service.CuponDescuentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v2/cupones_descuento")
public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponDescuentoService;

    // LISTAR TODOS
    @GetMapping
    public List<CuponDescuento> listarCuponDescuentos() {
        return cuponDescuentoService.getAllCupones();
    }

    // AGREGAR
    @PostMapping
    public CuponDescuento agregarCuponDescuento(@Valid @RequestBody CuponDescuento cuponDescuento) {
        return cuponDescuentoService.saveCuponDescuento(cuponDescuento);
    }

    // BUSCAR
    @GetMapping("{id_cupon}")
    public CuponDescuento buscarCuponDescuento(@PathVariable int id_cupon) {
        return cuponDescuentoService.getCuponDescuentoById(id_cupon);
    }

    // ACTUALIZAR
    @PutMapping("{id_cupon}")
    public int actualizarCuponDescuento(@PathVariable int id_cupon,
            @Valid @RequestBody CuponDescuento cuponDescuento) {
        cuponDescuento.setId_cupon(id_cupon); // ← asigna el id del path
        return cuponDescuentoService.updateCuponDescuento(cuponDescuento);
    }

    // ELIMINAR
    @DeleteMapping("{id_cupon}")
    public String eliminarCuponDescuento(@PathVariable int id_cupon) {
        if (cuponDescuentoService.deleteCuponDescuento(id_cupon) == 1) {
            return "Cupon de descuento eliminado correctamente";
        }
        return "Error al eliminar el cupon de descuento";
    }
}