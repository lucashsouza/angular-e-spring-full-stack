package br.com.lucashsouza.clientes.model.repository;

import br.com.lucashsouza.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
