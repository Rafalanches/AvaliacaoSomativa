package com.example.PrjXPTO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PrjXPTO.entities.Categoria;
import com.example.PrjXPTO.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria getCategoriaById(long Categoria_id) {
		return categoriaRepository.findById(Categoria_id).orElse(null);
	}

	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> buscarPorNome(String nome) {
		return categoriaRepository.buscarPorNome(nome);
	}
	public List<Categoria> buscarPorDescricao(String descricao) {
		return categoriaRepository.findByDescricao(descricao);
	}	
		

}
