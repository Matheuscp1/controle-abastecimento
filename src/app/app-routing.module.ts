import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { TableComponent } from './components/table/table.component';
import { FormSupplyComponent } from './components/form-supply/form-supply.component';

const routes: Routes = [
  { pathMatch: 'full', path: '', component: LoginComponent },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: TableComponent,
      },

      {
        path: 'novo-abastecimento',
        component: FormSupplyComponent,
      },
    ],
  },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
