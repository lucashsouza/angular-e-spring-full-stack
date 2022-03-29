import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'

import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor( private http : HttpClient ) { }

  salvar( cliente : Cliente ) : Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }

  getCliente() : Cliente {
    let cliente : Cliente = new Cliente();
    cliente.nome = "Lucas";
    cliente.cpf = "01740519051";

    return cliente;
  }
}
