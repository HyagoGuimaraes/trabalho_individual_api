package org.serratec.biblioteca.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroResposta> handleValidationException(MethodArgumentNotValidException ex){
		String erros = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
				.collect(Collectors.joining("; "));
		
		ErroResposta erro = new ErroResposta(LocalDateTime.now(), "Erro de Validação", erros);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroResposta> handleGeneralException(Exception ex){
		ErroResposta erro = new ErroResposta(LocalDateTime.now(), "Erro interno", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}
}
