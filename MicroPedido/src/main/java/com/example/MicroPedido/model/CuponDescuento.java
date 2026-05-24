package com.example.MicroPedido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity //se conecta con entidad
@Table(name="cupondescuento") //a tabla nombre persona
@Data //antes de data ahora va lo de arriba
@AllArgsConstructor
@NoArgsConstructor
public class CuponDescuento {
     @Id
    private int id_cupon; //pk
    @Column(name="codigo", nullable =false)
    private int codigo;
    private int descuento_pct;
    private int descuento_monto;
    private Date fecha_expiracion;
    private boolean activo;

}
