package com.example.PrjXPTO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PrjXPTO.entities.Aluno;
import com.example.PrjXPTO.entities.Turma;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//Query Methods
	
	
	//Query Methods
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByTurmaId(Long turma);
	List<Aluno> findByNomeLike(String nomeCompleto);
	List<Aluno> findByNomeAndRenda(String nome, Double renda);
	List<Aluno> findByCidadeAndRenda(String cidade, Double renda);
	List<Aluno> findByNome(String nome);
}
	

