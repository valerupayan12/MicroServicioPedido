package com.example.MicroPedido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private int id_producto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio_base", nullable = false)
    private int precio_base;

    @Column(name = "estado", nullable = false)
    private boolean estado;
//Para saber si el producto sigue vigente al momento de pedirlo
}
