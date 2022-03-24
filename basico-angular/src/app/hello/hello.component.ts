import { templateJitUrl } from '@angular/compiler';
import { Component } from '@angular/core' 

@Component( {
    selector: 'hello',
    templateUrl: './hello.component.html',
})
export class HelloComponent {
    
    nome : string;
    clientes: Cliente[];

    constructor() {
        this.nome = "Lucas";

        let fulano = new Cliente('Fulano', 30);
        let ciclano = new Cliente('Ciclano', 25);
        let outro = new Cliente('Outro', 32);

        this.clientes = [fulano, ciclano, outro];
    }

}

class Cliente {
    constructor(
        public nome: string,
        public idade: number
    ) {}
}