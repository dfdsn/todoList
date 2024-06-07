package com.malyah.ToDoList.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Status status;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	private LocalDateTime dataEdicao;
	private LocalDateTime dataRemocao;
	private LocalDateTime dataLimite;
	private Nivel prioridade;
	private Categoria categoria;
	private String tags;
	private String anotacoes;
	private String anexos;
	private String responsavel;
	
	private void setStatus(Status status) {
		if (getStatus().podeAlterarPara(status) ) {
			throw new IllegalArgumentException("Status inválido");
		}
		this.status = status;
	}

	public void novo() {
		setStatus(Status.NOVO);
		setDataCriacao(LocalDateTime.now());
	}
	
	public void emAndamento() {
		setStatus(Status.EM_ANDAMENTO);
		setDataEdicao(LocalDateTime.now());
	}
	
	public void concluido() {
		setStatus(Status.CONCLUIDO);
		setDataConclusao(LocalDateTime.now());
	}
	
	public void cancelado() {
		setStatus(Status.CANCELADO);
		setDataRemocao(LocalDateTime.now());
	}
	
	
	
}
