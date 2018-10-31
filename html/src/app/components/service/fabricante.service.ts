import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fabricante } from '../model/fabricante.model';

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {

  private URL_API = "http://localhost:8080/fabricante";

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Array<Fabricante>> {
    return this.http.get<Array<Fabricante>>(this.URL_API);
  }
}
