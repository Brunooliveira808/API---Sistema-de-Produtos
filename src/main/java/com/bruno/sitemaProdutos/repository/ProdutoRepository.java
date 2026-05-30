package com.bruno.sitemaProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bruno.sitemaProdutos.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


	
}
