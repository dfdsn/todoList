package com.malyah.ToDoList.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.malyah.ToDoList.api.assembler.ToDoAssembler;
import com.malyah.ToDoList.api.disassembler.TodoDisassembler;
import com.malyah.ToDoList.api.model.input.TodoInput;
import com.malyah.ToDoList.api.model.output.TodoView;
import com.malyah.ToDoList.domain.model.Todo;
import com.malyah.ToDoList.domain.service.TodoService;

@RestController
public class TodoController {

	private ToDoAssembler todoAssembler;
	private TodoDisassembler todoDisassembler;
	private TodoService todoService;
	
	public TodoController(ToDoAssembler todoAssembler, TodoDisassembler todoDisassembler, TodoService todoService) {
		this.todoAssembler = todoAssembler;
		this.todoDisassembler = todoDisassembler;
		this.todoService = todoService;
	}
	
	public List<TodoView> listar() {
		return todoAssembler.toCollectionModel(todoService.listar());
	}
	
	public TodoView salvar(TodoInput todoInput) {
		Todo todo = todoDisassembler.toDomainObject(todoInput);
		return todoAssembler.toModel(todoService.salvar(todo));
	}
	
	public void remover(Long todoId) {
		todoService.excluir(todoId);
	}
	
	public TodoView atualizar(Long todoId, TodoInput todoInput) {
		Todo todoAtual = todoService.buscar(todoId);
		todoDisassembler.copyToDomainObject(todoInput, todoAtual);
		return todoAssembler.toModel(todoService.salvar(todoAtual));
	}
	
	public TodoView buscarOuFalhar(Long todoId) {
		return todoAssembler.toModel(todoService.buscar(todoId));
	}
	
}
