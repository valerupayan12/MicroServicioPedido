package com.example.MicroPedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.MicroPedido.model.Categoria;
import com.example.MicroPedido.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // LISTAR TODAS
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.getCategorias();
    }

    // AGREGAR
    @PostMapping
    public Categoria agregarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.saveCategoria(categoria);
    }

    // BUSCAR POR ID
    @GetMapping("{id_categoria}")
    public Categoria buscarCategoria(@PathVariable int id_categoria) {
        return categoriaService.getCategoria(id_categoria);
    }

    // ACTUALIZAR
    @PutMapping("{id_categoria}")
    public int actualizarCategoria(@PathVariable int id_categoria,
            @RequestBody Categoria categoria) {

        categoria.setId_categoria(id_categoria);
        return categoriaService.updateCategoria(categoria);
    }

    // ELIMINAR
    @DeleteMapping("{id_categoria}")
    public String eliminarCategoria(@PathVariable int id_categoria) {

        if (categoriaService.deleteCategoria(id_categoria) == 1) {
            return "Categoría eliminada correctamente";
        }

        return "Error al eliminar categoría";
    }
}