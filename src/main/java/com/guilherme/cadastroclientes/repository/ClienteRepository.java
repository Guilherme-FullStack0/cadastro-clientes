package com.guilherme.cadastroclientes.repository;

import com.guilherme.cadastroclientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}