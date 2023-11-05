import { Subscription } from 'rxjs';
import { SupplyService } from 'src/app/services/supply.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
interface TableElements {
  plate: string;
  mileage: string;
  date: string;
  hour: string;
  total: number;
}
const ELEMENT_DATA: TableElements[] = [];
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent {
  constructor(private service: SupplyService, private router: Router) {}
  private subscriptionGetAll!: Subscription;
  private subscriptionDelete!: Subscription;
  ngOnInit() {
    this.getAllSupply();
  }

  public getAllSupply() {
    this.subscriptionGetAll = this.service.getAll().subscribe({
      next: (value) => {
        this.dataSource = value;
      },
      error: (error) => {},
    });
  }

  displayedColumns: string[] = [
    'plate',
    'mileage',
    'total',
    'hour',
    'date',
    'actions',
  ];
  dataSource = ELEMENT_DATA;
  navigationUpdate(id: string) {
    this.router.navigate([
      'home/editar-abastecimento',
      id,
    ]);
  }

  deleteSupply(id: string) {
    this.subscriptionDelete = this.service.delete(id).subscribe({
      next: (value) => {
        alert("DELETADO")
        this.getAllSupply()
      },
      error: (error) => {

      }
    })
  }

  ngOnDestroy() {
    // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
    this.subscriptionGetAll?.unsubscribe();
  }
}
