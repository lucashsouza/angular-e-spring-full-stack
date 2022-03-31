package br.com.lucashsouza.clientes.rest;

import br.com.lucashsouza.clientes.model.entity.Cliente;
import br.com.lucashsouza.clientes.model.entity.ServicoPrestado;
import br.com.lucashsouza.clientes.model.repository.ClienteRepository;
import br.com.lucashsouza.clientes.model.repository.ServicoPrestadoRepository;
import br.com.lucashsouza.clientes.rest.dto.ServicoPrestadoDTO;
import br.com.lucashsouza.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ServicoPrestadoRepository repository;
    private final ClienteRepository clienteRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        LocalDate date = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(date);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servicoPrestado);
    }

}
