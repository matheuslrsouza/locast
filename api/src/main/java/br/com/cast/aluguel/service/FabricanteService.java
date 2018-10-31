package br.com.cast.aluguel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.aluguel.dto.FabricanteDTO;
import br.com.cast.aluguel.entity.Fabricante;
import br.com.cast.aluguel.repository.FabricanteRepository;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public List<FabricanteDTO> buscarTodos() {
		List<Fabricante> fabricantes = fabricanteRepository.buscarTodos();
		return fabricantes.stream()
				.map(f -> deEntidade(f))
				.collect(Collectors.toList());
	}

	private FabricanteDTO deEntidade(Fabricante f) {
		FabricanteDTO dto = new FabricanteDTO();
		dto.setId(f.getId());
		dto.setNome(f.getNome());
		return dto;
	}
	
}
