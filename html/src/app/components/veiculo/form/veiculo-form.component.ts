import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Modelo } from '../../model/modelo.model';
import { Fabricante } from '../../model/fabricante.model';
import { FabricanteService } from '../../service/fabricante.service';
import { ModeloService } from '../../service/modelo.service';
import { VeiculoService } from '../../service/veiculo.service';
import { Router } from '@angular/router';
import { Veiculo } from '../../model/veiculo.model';

@Component({
  selector: 'app-veiculo-form',
  templateUrl: './veiculo-form.component.html',
  styleUrls: ['./veiculo-form.component.css']
})
export class VeiculoFormComponent implements OnInit {

  public fabricantes: Observable<Array<Fabricante>>;
  public modelos: Observable<Array<Modelo>>;
  public form: FormGroup;
  public mensagemErro: string;

  constructor(private fabricanteService: FabricanteService,
    private modeloService: ModeloService,
    private veiculoService: VeiculoService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      placa: ['', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]{3}[0-9]{4}$/g)
      ]],
      ano: ['', [
        Validators.required,
        Validators.pattern(/^(19|20)\d{2}$/g)
      ]],
      id_fabricante: ['', [
        Validators.required
      ]],
      id_modelo: ['', [
        Validators.required
      ]]
    });

    this.getFabricantes();
  }

  public salvar(veiculo: Veiculo): void {
    this.mensagemErro = '';
    this.veiculoService.save(veiculo).subscribe(() => {
      this.router.navigate(['/veiculo/']);
    }, erro => {
      this.mensagemErro = erro.error.message;
      this.form.controls.placa.reset();
    });
  }
  
  private getFabricantes(): void {
    this.fabricantes = this.fabricanteService.getAll();
  }

  public getModelos(id_fabricante: number): void {
    this.form.controls.id_modelo.setValue('');
    if (id_fabricante) {
      this.modelos = this.modeloService.getByFabricante(id_fabricante);
    }
  }

}
