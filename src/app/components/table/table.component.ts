import { Component } from '@angular/core';
interface TableElements {
  plate: string;
  mileage: string;
  date: string;
  hour: string;
  total: number
}
const ELEMENT_DATA: TableElements[] = [
  {plate: '1', mileage: 'Hydrogen', date: '20/10/2021', total: 1.0079, hour: 'H'},
  {plate: '2', mileage: 'Helium',  date: '20/10/2021',total: 4.0026, hour: 'He'},
  {plate: '3', mileage: 'Lithium',  date: '20/10/2021', total: 6.941, hour: 'Li'},
  {plate: '4', mileage: 'Beryllium',  date: '20/10/2021', total: 9.0122, hour: 'Be'},
  {plate: '5', mileage: 'Boron',  date: '20/10/2021', total: 10.811, hour: 'B'},
  {plate: '6', mileage: 'Carbon',  date: '20/10/2021', total: 12.0107, hour: 'C'},
  {plate: '7', mileage: 'Nitrogen',  date: '20/10/2021', total: 14.0067, hour: 'N'},
  {plate: '8', mileage: 'Oxygen',  date: '20/10/2021', total: 15.9994, hour: 'O'},
  {plate: '9', mileage: 'Fluorine',  date: '20/10/2021', total: 18.9984, hour: 'F'},
  {plate: '10', mileage: 'Neon',   date: '20/10/2021',total: 20.1797, hour: 'Ne'},
];
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent {



  displayedColumns: string[] = ['plate', 'mileage', 'total', 'hour', 'date'];
  dataSource = ELEMENT_DATA;
}
