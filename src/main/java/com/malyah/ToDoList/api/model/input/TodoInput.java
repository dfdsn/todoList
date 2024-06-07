package com.malyah.ToDoList.api.model.input;

import java.time.LocalDateTime;

import com.malyah.ToDoList.domain.model.Categoria;
import com.malyah.ToDoList.domain.model.Nivel;
import com.malyah.ToDoList.domain.model.Status;

import lombok.Data;

@Data
public class TodoInput {
	private String titulo;
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
}
