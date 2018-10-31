package br.com.cast.aluguel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.aluguel.dto.VeiculoFormDTO;
import br.com.cast.aluguel.dto.VeiculoListDTO;
import br.com.cast.aluguel.exception.VeiculoExistenteException;
import br.com.cast.aluguel.service.VeiculoService;

@RestController
@RequestMapping(path = "veiculo")
public class VeiculoAPI {

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public List<VeiculoListDTO> buscarTodos() {
		return veiculoService.buscarTodos();
	}
	
	@PostMapping
	public void inserir(@RequestBody VeiculoFormDTO formDTO) throws VeiculoExistenteException {
		veiculoService.inserir(formDTO);
	}
}
