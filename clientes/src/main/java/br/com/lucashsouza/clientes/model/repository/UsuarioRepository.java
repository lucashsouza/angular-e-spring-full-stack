package br.com.lucashsouza.clientes.model.repository;

import br.com.lucashsouza.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
