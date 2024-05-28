package com.example.PrjXPTO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrjXPTO.entities.Livro;
import com.example.PrjXPTO.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}

	public Livro getLivroById(long Livro_id) {
		return livroRepository.findById(Livro_id).orElse(null);
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public List<Livro> buscarPorTitulo(String titulo) {
		return livroRepository.buscarPorTitulo(titulo);
	}
	public List<Livro> buscarPorAno(String ano) {
		return livroRepository.findByAno(ano);
	}

}
