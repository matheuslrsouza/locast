package br.com.cast.aluguel.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VeiculoExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public VeiculoExistenteException() {
		super("Veículo clonado!");
	}
}
