package br.com.lucashsouza.clientes.rest;

import br.com.lucashsouza.clientes.model.entity.Cliente;
import br.com.lucashsouza.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public Cliente acharPorId(@PathVariable Integer id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable("id") Integer id, @RequestBody @Valid Cliente clienteAtualizado) {
        clienteRepository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return clienteRepository.save(clienteAtualizado);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deletar(@PathVariable Integer id) {
        clienteRepository
                .findById(id)
                .map(cliente -> {
                clienteRepository.delete(cliente);
                return Void.TYPE;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
