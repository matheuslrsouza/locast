import { Component, OnInit } from '@angular/core';
import { VeiculoService } from '../../service/veiculo.service';
import { Observable } from 'rxjs';
import { Veiculo } from '../../model/veiculo.model';

@Component({
  selector: 'app-veiculo-list',
  templateUrl: './veiculo-list.component.html',
  styleUrls: ['./veiculo-list.component.css']
})
export class VeiculoListComponent implements OnInit {

  public veiculos: Observable<Array<Veiculo>>;

  constructor(private veiculoService: VeiculoService) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.veiculos = this.veiculoService.getAll();
  }
}
