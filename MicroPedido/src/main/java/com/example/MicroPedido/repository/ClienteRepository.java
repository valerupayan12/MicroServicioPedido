package com.example.MicroPedido.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroPedido.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {
    Optional<Cliente> findById(Integer id_cliente);

    boolean existsById(Integer id_cliente);

    List<Cliente> findByIdGenero(Integer id_genero);
}
