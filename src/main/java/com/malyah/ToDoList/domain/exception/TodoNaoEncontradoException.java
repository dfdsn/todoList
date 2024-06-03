package com.malyah.ToDoList.domain.exception;

public class TodoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TodoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TodoNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de todo com código %d", id));
	}

}
