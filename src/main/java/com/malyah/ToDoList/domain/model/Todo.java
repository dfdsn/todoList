package com.malyah.ToDoList.domain.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.malyah.ToDoList.validation.Today;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotBlank
	private String titulo;
	@NotNull
	private Status status;
	@NotNull
	@Length(min = 10, max = 300)
	private String descricao;
	@Today
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	private LocalDateTime dataEdicao;
	private LocalDateTime dataRemocao;
	@FutureOrPresent
	private LocalDateTime dataLimite;
	@NotNull
	private Nivel prioridade;
	@NotNull
	private Categoria categoria;
	private String tags;
	private String anotacoes;
	private String anexos;
	@NotBlank
	private String responsavel;
	
	private void setStatus(Status status) {
		if (getStatus().podeAlterarPara(status) ) {
			throw new IllegalArgumentException("Status inválido");
		}
		this.status = status;
	}

	public void novo() {
		status = Status.NOVO;
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
