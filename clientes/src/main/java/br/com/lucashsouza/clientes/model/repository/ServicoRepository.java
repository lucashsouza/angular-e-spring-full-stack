package br.com.lucashsouza.clientes.model.repository;

import br.com.lucashsouza.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
