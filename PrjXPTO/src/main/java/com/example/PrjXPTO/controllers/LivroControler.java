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

import com.example.PrjXPTO.entities.Livro;
import com.example.PrjXPTO.services.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroControler {
	
	private final LivroService livroService;

	@Autowired
	public LivroControler(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> findLivrobyId(@PathVariable Long id) {
		Livro livro = livroService.getLivroById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Livro>> findAllUsuarioscontrol() {
		List<Livro> livro = livroService.getAllLivros();
		return ResponseEntity.ok(livro);
	}

	@PostMapping("/")
	public ResponseEntity<Livro> insertLivrosControl(@RequestBody Livro livro) {
		Livro novolivro = livroService.saveLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(novolivro);
	}
	
	@GetMapping("/titulo/{titulo}")
	public List<Livro> buscarPorTitulo(@PathVariable String titulo){
		return livroService.buscarPorTitulo(titulo);
	}
	
	@GetMapping("/ano/{ano}")
	public List<Livro> buscarPorAno(@PathVariable String ano){
		return livroService.buscarPorAno(ano);
	}

}
