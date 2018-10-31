import { Injectable } from '@angular/core';
import { Modelo } from '../model/modelo.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModeloService {

  private URL_API = "http://localhost:8080/modelo";

  constructor(private http: HttpClient) { }

  public getByFabricante(id_fabricante: number): Observable<Array<Modelo>> {
    return this.http.get<Array<Modelo>>(`${this.URL_API}/${id_fabricante}`);
  }
}
