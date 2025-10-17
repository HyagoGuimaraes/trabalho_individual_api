package org.serratec.biblioteca.exception;

import java.time.LocalDateTime;

public class ErroResposta {
	
	private LocalDateTime dataHora;
	private String mensagem;
	private String detalhe;
	
	public ErroResposta(LocalDateTime dataHora, String mensagem, String detalhe) {
		this.dataHora = dataHora;
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
}
