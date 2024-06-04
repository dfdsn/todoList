package com.malyah.ToDoList.api.disassembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.malyah.ToDoList.api.model.input.TodoInput;
import com.malyah.ToDoList.domain.model.Todo;

@Component
public class TodoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Todo toDomainObject(TodoInput todoInput) {
		return modelMapper.map(todoInput, Todo.class);
	}
	
	public void copyToDomainObject(TodoInput todoInput, Todo todo) {
		modelMapper.map(todoInput, todo);
	}
}
