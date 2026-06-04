package com.example.MicroPedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroPedido.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> { // ✅ Long → Integer


    List<Producto> findByEstado(boolean estado); // campo existe

    boolean existsByNombreIgnoreCase(String nombre); //  campo existe
}