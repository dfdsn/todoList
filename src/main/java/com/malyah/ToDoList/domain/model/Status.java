package com.malyah.ToDoList.domain.model;

import java.util.List;

public enum Status {
	NOVO("Novo"), 
	EM_ANDAMENTO("Em andamento", NOVO), 
	CONCLUIDO("Concluído", EM_ANDAMENTO), 
	CANCELADO("Cancelado", NOVO);
	
	private String descricao;
	private List<Status> statusAnterior;
	
	Status(String descricao, Status... statusAnterior) {
        this.descricao = descricao;
    }
	
	public String getDescricao() {
        return descricao;
    }
	
	public boolean podeAlterarPara(Status novoStatus) {
		return novoStatus.statusAnterior.contains(this);
	}
}
