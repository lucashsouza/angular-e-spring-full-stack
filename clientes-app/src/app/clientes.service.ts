import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor() { }

  getCliente() : Cliente {
    let cliente : Cliente = new Cliente();
    cliente.nome = "Lucas";
    cliente.cpf = "01740519051";

    return cliente;
  }
}
