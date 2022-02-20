import { Injectable } from '@angular/core';
import { CLIENTES } from './clientes.json';
import { Cliente } from './cliente';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ClienteService {
  private urlEndpoint :string = 'http://localhost:8080/api/clientes';
  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]>{
    //return CLIENTES;
    return this.http.get<Cliente[]>(this.urlEndpoint);
  }
}
