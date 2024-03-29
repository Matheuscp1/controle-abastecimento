import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { MatNativeDateModule, MatOptionModule } from '@angular/material/core';
import { MatDividerModule } from '@angular/material/divider';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { LoginComponent } from './pages/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './pages/home/home.component';
import { TableComponent } from './components/table/table.component';
import { FormSupplyComponent } from './components/form-supply/form-supply.component';
import { NgxCurrencyDirective } from 'ngx-currency';
import localePt from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';
import { OnlyNumberDirective } from './directives/only-numbers.directive';
import {MatPaginatorIntl, MatPaginatorModule} from '@angular/material/paginator'
import { MatDialogModule} from '@angular/material/dialog';;
import { CustomPaginator } from 'src/utils/customPaginator';
import { ModalComponent } from './components/modal/modal.component';

registerLocaleData(localePt);
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    TableComponent,
    FormSupplyComponent,
    OnlyNumberDirective,
    ModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatInputModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatOptionModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatDividerModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgxCurrencyDirective,
    MatPaginatorModule,
    MatDialogModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'pt' }, {
    provide: MatPaginatorIntl,
    useValue: CustomPaginator(),
  },],
  bootstrap: [AppComponent],
})
export class AppModule {}
