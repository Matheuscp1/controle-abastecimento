import { Subscription } from 'rxjs';
import { SupplyService } from 'src/app/services/supply.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import {MatDialog} from '@angular/material/dialog';
import { ModalComponent } from '../modal/modal.component';
interface TableElements {
  plate: string;
  mileage: string;
  date: string;
  total: number;
}
const ELEMENT_DATA: TableElements[] = [];
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent {
  constructor(private service: SupplyService, private router: Router,public dialog: MatDialog) {}
  private subscriptionGetAll!: Subscription;
  private subscriptionDelete!: Subscription;
  ngOnInit() {
    this.getAllSupply();
  }

  public getAllSupply() {
    this.subscriptionGetAll = this.service.getAll(this.pageSize,this.pageIndex).subscribe({
      next: (value) => {
        this.dataSource = value.content;
        this.pageIndex = value.pageable.pageNumber
        this.length = value.totalElements
      },
      error: (error) => {},
    });
  }
  length = 0;
  pageSize = 10;
  pageIndex = 0;
  pageSizeOptions = [5, 10, 20, 50];
  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  pageEvent!: PageEvent;
  offset = this.pageSize * (this.pageIndex ) - this.pageSize;

  displayedColumns: string[] = [
    'plate',
    'mileage',
    'total',
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

  handlePageEvent(e: PageEvent) {
    this.offset = e.pageSize * (e.pageIndex + 1) - e.pageSize;
    this.pageEvent = e;
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    console.log(this.pageSize)
    this.getAllSupply()
  }

  deleteModal(id: string) {
    this.openDialog('0ms', '0ms',() => this.deleteSupply(id))
  }

  deleteSupply(id: string){
    this.subscriptionDelete = this.service.delete(id).subscribe({
      next: (value) => {
        this.getAllSupply()
      },
      error: (error) => {

      }
    })
  }

  openDialog(enterAnimationDuration: string, exitAnimationDuration: string, primaryFunction:Function): void {
    this.dialog.open(ModalComponent, {
      data: {primaryFunction},
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }

  ngOnDestroy() {
    // Realize o unsubscribe no ngOnDestroy para evitar memory leaks
    this.subscriptionGetAll?.unsubscribe();
    this.subscriptionDelete?.unsubscribe();
  }
}
