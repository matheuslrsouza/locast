package br.com.cast.aluguel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.aluguel.dto.VeiculoFormDTO;
import br.com.cast.aluguel.dto.VeiculoListDTO;
import br.com.cast.aluguel.entity.Modelo;
import br.com.cast.aluguel.entity.Veiculo;
import br.com.cast.aluguel.exception.VeiculoExistenteException;
import br.com.cast.aluguel.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public List<VeiculoListDTO> buscarTodos() {
		List<Veiculo> veiculos = veiculoRepository.buscarTodos();
		List<VeiculoListDTO> dtos = new ArrayList<>();
		
		for (Veiculo veiculo : veiculos) {
			dtos.add(deEntidade(veiculo));
		}
		
		return dtos;
	}
	
	@Transactional
	public void inserir(VeiculoFormDTO dto) throws VeiculoExistenteException {
		
		if (veiculoRepository.buscarPorPlaca(dto.getPlaca()) != null) {
			throw new VeiculoExistenteException();
		}
		
		Veiculo veiculo = new Veiculo();
		Modelo modelo = new Modelo().setId(dto.getIdModelo());
		
		veiculo.setAno(dto.getAno());
		veiculo.setModelo(modelo);
		veiculo.setPlaca(dto.getPlaca().toUpperCase());
		
		veiculoRepository.inserir(veiculo);
		
	}

	private VeiculoListDTO deEntidade(Veiculo veiculo) {
		VeiculoListDTO dto = new VeiculoListDTO();
		dto.setAno(veiculo.getAno());
		dto.setFabricante(veiculo.getModelo().getFabricante().getNome());
		dto.setModelo(veiculo.getModelo().getNome());
		dto.setPlaca(veiculo.getPlaca());
		return dto;
	}
}
