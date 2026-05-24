package com.example.MicroPedido.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //se conecta con entidad
@Table(name="pedido") //la tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    // Relación correcta con tu tabla espejo Cliente (vía id_cliente)
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
    private Cliente cliente;

    // Relación correcta con tu tabla espejo Tienda (vía id_tienda)
    @ManyToOne
    @JoinColumn(name="id_tienda", nullable=false)
    private Tienda tienda;

    // CORRECCIÓN: Cambiado a String para soportar estados como: PENDIENTE, ENVIADO, ENTREGADO
    @Column(name="estado", nullable=false)
    private String estado;

    // CORRECCIÓN: Guardamos solo el ID numérico del cupón y permitimos que sea NULL (no obligatorio)
    @Column(name="id_cupon", nullable=true)
    private Integer id_cupon; 

    @Column(name="fecha_pedido", nullable=false)
    private Date fecha_pedido;

    // AGREGADO: Atributo indispensable para registrar el total de la venta
    @Column(name="total", nullable=false)
    private int total;
}
