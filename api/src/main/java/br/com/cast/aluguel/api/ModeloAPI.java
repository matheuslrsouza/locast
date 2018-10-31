package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.dto.ModeloDTO;
import br.com.cast.aluguel.service.ModeloService;

@RestController
@RequestMapping(path = "modelo")
public class ModeloAPI {

	@Autowired
	private ModeloService modeloService;

	@GetMapping(path = "/{idFabricante}")
	public List<ModeloDTO> buscarPorFabricante(@PathVariable("idFabricante") Integer idFabricante) {
		return modeloService.buscarPorFabricante(idFabricante);
	}
	
}
