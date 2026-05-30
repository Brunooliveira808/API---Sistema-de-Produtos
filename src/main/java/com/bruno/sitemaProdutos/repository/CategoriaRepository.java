package com.bruno.sitemaProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bruno.sitemaProdutos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
