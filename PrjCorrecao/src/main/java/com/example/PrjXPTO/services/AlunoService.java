package com.example.PrjXPTO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrjXPTO.entities.Aluno;
import com.example.PrjXPTO.repositories.AlunoRepository;


@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method 
    public List<Aluno> buscarAlunosPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }
    //Query Method 
    public List<Aluno> buscarAlunosPorNomeERenda(String nome, Double renda) {
        return alunoRepository.findByNomeAndRenda(nome,renda); 
      }
    //Query Method 
    public List<Aluno> buscarAlunosPorNome(String nome) {
        return alunoRepository.findByNome(nome); 
      }
  //Query Method 
    public List<Aluno> buscarCidadeERenda(String cidade, Double renda) {
        return alunoRepository.findByCidadeAndRenda(cidade,renda); 
      }
  //@query
    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }
  //@query
    public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
        return alunoRepository.findByNomeLike(nomeCompleto);
    }
   //@query
    public List<Aluno> findByTurmaId(Long turmaId) {
        return alunoRepository.findByTurmaId(turmaId);
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}