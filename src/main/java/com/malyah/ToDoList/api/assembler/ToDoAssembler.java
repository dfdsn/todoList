package com.malyah.ToDoList.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.malyah.ToDoList.api.model.output.TodoView;
import com.malyah.ToDoList.domain.model.Todo;

@Component
public class ToDoAssembler {

	
	@Autowired
	private ModelMapper modelMapper;
	
	public TodoView toModel(Todo todo) {
		return modelMapper.map(todo, TodoView.class);
	}
	
	public List<TodoView> toCollectionModel(List<Todo> todos) {
		return todos.stream().map(todo -> toModel(todo)).collect(Collectors.toList());
	}

}
