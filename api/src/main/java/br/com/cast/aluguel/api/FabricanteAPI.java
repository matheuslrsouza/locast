package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.dto.FabricanteDTO;
import br.com.cast.aluguel.service.FabricanteService;

@RestController
@RequestMapping(path = "fabricante")
public class FabricanteAPI {

	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping
	public List<FabricanteDTO> buscarTodos() {
		return fabricanteService.buscarTodos();
	}
}
