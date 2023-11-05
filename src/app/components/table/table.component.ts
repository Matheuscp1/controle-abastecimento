import { SupplyService } from 'src/app/services/supply.service';
import { Component } from '@angular/core';
interface TableElements {
  plate: string;
  mileage: string;
  date: string;
  hour: string;
  total: number
}
const ELEMENT_DATA: TableElements[] = [];
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent {
  constructor(private service: SupplyService){}

  public getAllSupply(){
    this.service.getAll().subscribe({
      next: (value) => {
        this.dataSource = value
      },
      error: (error) => {

      }
    })
  }
  ngOnInit(){
    this.getAllSupply()
  }
  displayedColumns: string[] = ['plate', 'mileage', 'total', 'hour', 'date', 'actions'];
  dataSource = ELEMENT_DATA;
}
