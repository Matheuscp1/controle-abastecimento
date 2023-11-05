import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupplyService {

  constructor(private httpClient: HttpClient) { }
  private urlApi = environment.apiUrl;

  public saveSupply(supply: FormGroup): Observable<any> {
    return this.httpClient.post<Response>(`${this.urlApi}/supply`, supply.value);
  }

  public getAll(size:number,page:number): Observable<any> {
    return this.httpClient.get<Response>(`${this.urlApi}/supply?page=${page}&size=${size}`);
  }

  public getById(id:string): Observable<any> {
    return this.httpClient.get<Response>(`${this.urlApi}/supply/${id}`,);
  }

  public update(supply: any): Observable<any> {
    return this.httpClient.put<Response>(`${this.urlApi}/supply`, supply);
  }


  public delete(id:string): Observable<any> {
    return this.httpClient.delete<Response>(`${this.urlApi}/supply/${id}`, );
  }
}
