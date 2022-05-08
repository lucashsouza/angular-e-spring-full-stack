import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { ServicoPrestadoFormComponent } from './servico-prestado-form/servico-prestado-form.component';
import { ServicoPrestadoListaComponent } from './servico-prestado-lista/servico-prestado-lista.component';


const routes: Routes = [ 
  { path: 'servicos-prestados', component: LayoutComponent, children: [
    { path: '', redirectTo: '/servicos-prestados/lista', pathMatch: 'full' },
    { path: 'form', component: ServicoPrestadoFormComponent },
    { path: 'lista', component: ServicoPrestadoListaComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicoPrestadoRoutingModule { }
