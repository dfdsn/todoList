package com.malyah.ToDoList.domain.service;

import static com.malyah.ToDoList.constants.ToDoConstants.TODO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.malyah.ToDoList.domain.model.Status;
import com.malyah.ToDoList.domain.model.Todo;
import com.malyah.ToDoList.domain.repository.TodoRepository;

@ExtendWith(MockitoExtension.class)
 class TodoServiceTest {
	
	@InjectMocks
	private TodoService todoService;

	@Mock
	private TodoRepository todoRepository;

	@Test
	void salvar_todo_retorna_sucesso() {
		when(todoRepository.save(TODO)).thenReturn(TODO);

		Todo sut = todoService.salvar(TODO);
		assertThat(sut).isNotNull();
		assertThat(sut.getId()).isNotNull();
		assertThat(sut.getStatus().equals(Status.NOVO));
		assertThat(sut.getTitulo()).as("O título não deve ser nulo ou vazio").isNotNull()
	    		.satisfies(title -> {assertThat(title).isNotBlank();});
		assertThat(sut.getDescricao()).as("A descrição não deve ser nula ou vazia").isNotNull()
        		.satisfies(description -> {assertThat(description).isNotBlank();});
		assertThat(sut.getDataCriacao()).as("A data de criação é obrigatorio").isNotNull();
		assertThat(sut.getPrioridade()).as("A prioridade é obrigatória").isNotNull();
	}
	@Test
	void excluir_todo_retorna_sucesso() {
		todoService.excluir(1L);
		verify(todoRepository, times(1)).deleteById(1L);
	}


	@Test
	void buscarTodoPorId_retorna_sucesso() {
		when(todoRepository.findById(1L)).thenReturn(java.util.Optional.of(TODO));
		assertThat(todoService.buscar(1L)).isEqualTo(TODO);
	}

	

}
