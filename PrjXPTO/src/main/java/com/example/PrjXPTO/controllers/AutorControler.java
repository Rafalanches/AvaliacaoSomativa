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

import com.example.PrjXPTO.entities.Autor;
import com.example.PrjXPTO.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorControler {

	private final AutorService autorService;

	@Autowired
	public AutorControler(AutorService autorService) {
		this.autorService = autorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> findAutorbyId(@PathVariable Long id) {
		Autor autor = autorService.getAutorById(id);
		if (autor != null) {
			return ResponseEntity.ok(autor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Autor>> findAllUsuarioscontrol() {
		List<Autor> autor = autorService.getAllAutores();
		return ResponseEntity.ok(autor);
	}

	@PostMapping("/")
	public ResponseEntity<Autor> insertAutorControl(@RequestBody Autor autor) {
		Autor novoAutor = autorService.saveAutor(autor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Autor> buscarPorNome(@PathVariable String nome){
		return autorService.buscarPorNome(nome);
	}
	
	@GetMapping("/pais/{pais}")
	public List<Autor> buscarPorPais(@PathVariable String pais){
		return autorService.buscarPorPais(pais);
	}
}
