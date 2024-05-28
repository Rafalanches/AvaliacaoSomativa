package com.example.PrjXPTO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrjXPTO.entities.Autor;
import com.example.PrjXPTO.repositories.AutorRepository;


@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> getAllAutores() {
		return autorRepository.findAll();
	}

	public Autor getAutorById(long Autor_id) {
		return autorRepository.findById(Autor_id).orElse(null);
	}

	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public List<Autor> buscarPorNome(String nome) {
		return autorRepository.buscarPorNome(nome);
	}
	public List<Autor> buscarPorPais(String pais) {
		return autorRepository.findByPais(pais);
	}
}
