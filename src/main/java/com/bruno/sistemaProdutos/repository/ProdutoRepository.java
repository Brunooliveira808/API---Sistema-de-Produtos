package com.bruno.sistemaProdutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bruno.sistemaProdutos.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByNomeContainingIgnoreCase(String nome);
	
    List<Produto> findByCategoriasNomeIgnoreCase(String categoria);
}
