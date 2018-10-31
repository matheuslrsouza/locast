import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Veiculo } from '../model/veiculo.model';

@Injectable({
  providedIn: 'root'
})
export class VeiculoService {

  private URL_API = "http://localhost:8080/veiculo";

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Array<Veiculo>> {
    return this.http.get<Array<Veiculo>>(this.URL_API);
  }
  
  public save(veiculo: Veiculo): Observable<void> {
    return this.http.post<void>(this.URL_API, veiculo);
  }
}
