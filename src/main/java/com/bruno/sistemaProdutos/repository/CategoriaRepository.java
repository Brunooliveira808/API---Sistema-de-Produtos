package com.bruno.sistemaProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.sistemaProdutos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
