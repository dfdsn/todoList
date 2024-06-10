package com.malyah.ToDoList.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malyah.ToDoList.api.assembler.ToDoAssembler;
import com.malyah.ToDoList.api.disassembler.TodoDisassembler;
import com.malyah.ToDoList.api.model.input.TodoInput;
import com.malyah.ToDoList.api.model.output.TodoView;
import com.malyah.ToDoList.domain.model.Status;
import com.malyah.ToDoList.domain.model.Todo;
import com.malyah.ToDoList.domain.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	private ToDoAssembler todoAssembler;
	private TodoDisassembler todoDisassembler;
	private TodoService todoService;
	
	public TodoController(ToDoAssembler todoAssembler, TodoDisassembler todoDisassembler, TodoService todoService) {
		this.todoAssembler = todoAssembler;
		this.todoDisassembler = todoDisassembler;
		this.todoService = todoService;
	}
	
	@GetMapping
	public List<TodoView> listar() {
		return todoAssembler.toCollectionModel(todoService.listar());
	}
	
	@PostMapping
	public ResponseEntity<TodoView> salvar(@RequestBody TodoInput todoInput) {
		Todo todo = todoDisassembler.toDomainObject(todoInput);
		todo.novo();
		return ResponseEntity.ok(todoAssembler.toModel(todoService.salvar(todo)));
	}
	
	@DeleteMapping("/{todoId}")
	public void remover(@PathVariable Long todoId) {
		todoService.excluir(todoId);
	}
	
	@PutMapping("/{todoId}")
	public TodoView atualizar(@PathVariable Long todoId, @RequestBody TodoInput todoInput) {
		Todo todoAtual = todoService.buscar(todoId);
		todoDisassembler.copyToDomainObject(todoInput, todoAtual);
		return todoAssembler.toModel(todoService.salvar(todoAtual));
	}
	
	@GetMapping("/{todoId}")
	public TodoView buscarOuFalhar(@PathVariable Long todoId) {
		return todoAssembler.toModel(todoService.buscar(todoId));
	}
	
}
