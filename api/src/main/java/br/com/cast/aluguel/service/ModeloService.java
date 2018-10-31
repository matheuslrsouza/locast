package br.com.cast.aluguel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.aluguel.dto.ModeloDTO;
import br.com.cast.aluguel.entity.Modelo;
import br.com.cast.aluguel.repository.ModeloRepository;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;
	
	public List<ModeloDTO> buscarPorFabricante(Integer idFabricante) {
		List<Modelo> modelos = modeloRepository.buscarPorFabricante(idFabricante);
		return modelos.stream()
				.map(m -> deEntidade(m))
				.collect(Collectors.toList());
	}
	
	private ModeloDTO deEntidade(Modelo m) {
		ModeloDTO dto = new ModeloDTO();
		dto.setId(m.getId());
		dto.setNome(m.getNome());
		return dto;
	}
}
