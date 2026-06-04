package com.example.MicroPedido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tienda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {

    @Id
    private int id_tienda;

    @Column(name="nombre", nullable=false)
    private String nombre;

    @Column(name="direccion", nullable=false)
    private String direccion;

    @Column(name="id_comuna", nullable=false)
    private int id_comuna;
}