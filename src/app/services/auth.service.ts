import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { getLocalStorage, setLocalStorage } from '../../utils/localStorage';
const KEY_USER = 'user';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private httpClient: HttpClient) { }
  urlApi = environment.apiUrl;

  public login(login: FormGroup): Observable<any> {
    return this.httpClient.post<Response>(`${this.urlApi}/users`, login.value);
  }

  public isSignin(){
    return !!this.getUser()
  }

  getUser(){
    return getLocalStorage(KEY_USER) ?? ''
  }

  setUser(user:any){
    setLocalStorage(KEY_USER,user)
  }
}
