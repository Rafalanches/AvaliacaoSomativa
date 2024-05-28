package com.example.PrjXPTO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PrjXPTO.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	@Query(value = "SELECT * FROM Autor l WHERE lower(l.nome) LIKE %:nome", nativeQuery = true)
	List<Autor> buscarPorNome(@Param("nome") String nome);
	
	@Query(value = "SELECt l FROM Autor l WHERE l.pais = ?1")
	List<Autor> findByPais(String pais);	
	
}
