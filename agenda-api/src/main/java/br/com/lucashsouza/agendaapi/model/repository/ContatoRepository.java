package br.com.lucashsouza.agendaapi.model.repository;

import br.com.lucashsouza.agendaapi.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
