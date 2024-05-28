package com.example.PrjXPTO.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PrjXPTO.entities.Categoria;
import com.example.PrjXPTO.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaControler {
	
	private final CategoriaService categoriaService;

	@Autowired
	public CategoriaControler(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findCategoriabyId(@PathVariable Long id) {
		Categoria categoria = categoriaService.getCategoriaById(id);
		if (categoria != null) {
			return ResponseEntity.ok(categoria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Categoria>> findAllUsuarioscontrol() {
		List<Categoria> categoria = categoriaService.getAllCategorias();
		return ResponseEntity.ok(categoria);
	}

	@PostMapping("/")
	public ResponseEntity<Categoria> insertCategoriaControl(@RequestBody Categoria categoria) {
		Categoria novoCategoria = categoriaService.saveCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCategoria);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Categoria> buscarPorNome(@PathVariable String nome){
		return categoriaService.buscarPorNome(nome);
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<Categoria> buscarPorDescricao(@PathVariable String pais){
		return categoriaService.buscarPorDescricao(pais);
	}

}
