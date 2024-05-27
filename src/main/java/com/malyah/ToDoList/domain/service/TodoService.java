package com.malyah.ToDoList.domain.service;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malyah.ToDoList.domain.model.Todo;
import com.malyah.ToDoList.domain.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public void excluirTodos() {
		todoRepository.deleteAll();
	}
	
	public void excluir(Long id) {
		todoRepository.deleteById(id);
	}
	
	public List<Todo> listar() {
		return todoRepository.findAll();
	}
	
	public Todo buscar(Long id) {
		return todoRepository.findById(id).orElseThrow();
	}
	
	public Todo salvar(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Todo atualizar(long id, Todo todo) {
		Todo todoAtual = buscar(id);
		try {
			BeanUtils.copyProperties(todo, todoAtual);
			return todoRepository.save(todoAtual);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return todoRepository.save(todo);
	}
	
	
}
