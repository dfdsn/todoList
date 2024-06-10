package com.malyah.ToDoList.constants;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.malyah.ToDoList.domain.model.Categoria;
import com.malyah.ToDoList.domain.model.Nivel;
import com.malyah.ToDoList.domain.model.Status;
import com.malyah.ToDoList.domain.model.Todo;

public class ToDoConstants {
	
	public static final String TITULO = "titulo";
	public static final Status STATUS = Status.NOVO; 
	public static final String DESCRICAO = "descricao";
	public static final LocalDateTime DATA_CRIACAO = LocalDateTime.now();
	public static final LocalDateTime DATA_CONCLUSAO = LocalDateTime.of(2024, 6, 10, 10, 30);
	public static final LocalDateTime DATA_EDICAO = LocalDateTime.of(2024, 6, 10, 10, 30);
	public static final LocalDateTime DATA_REMOCAO = LocalDateTime.of(2024, 6, 10, 10, 30);
	public static final LocalDateTime DATA_LIMITE = LocalDateTime.of(2024, 6, 10, 10, 30);
	public static final Nivel PRIORIDADE = Nivel.ALTO;
	public static final Categoria CATEGORIA = Categoria.TRABALHO;
	public static final String TAGS = "tags";
	public static final String ANOTACOES = "anotacoes";
	public static final String ANEXOS = "anexos";
	public static final String RESPONSAVEL = "responsavel";
	
	public static final Todo TODO = new Todo(1L, TITULO, STATUS, DESCRICAO, DATA_CRIACAO, null, null, null, null, PRIORIDADE, CATEGORIA, null, null, null, null);
    public static final Todo TODO2 = new Todo(2L, "TITULO 2", STATUS, DESCRICAO, DATA_CRIACAO, DATA_CONCLUSAO, DATA_EDICAO, DATA_REMOCAO, DATA_LIMITE, PRIORIDADE, CATEGORIA, TAGS, ANOTACOES, ANEXOS, RESPONSAVEL);
    public static final Todo TODO3 = new Todo(3L, "TITULO 3", STATUS, DESCRICAO, DATA_CRIACAO, DATA_CONCLUSAO, DATA_EDICAO, DATA_REMOCAO, DATA_LIMITE, PRIORIDADE, CATEGORIA, null, ANOTACOES, ANEXOS, RESPONSAVEL);

    public static final List<Todo> TODOS = Arrays.asList(TODO, TODO2, TODO3);
}
