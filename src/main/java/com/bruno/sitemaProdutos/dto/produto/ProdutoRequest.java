package com.bruno.sitemaProdutos.dto.produto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


public record ProdutoRequest(
		
		@NotBlank
		String nome, 
		
		@Positive
		double preco, 
		
		@NotEmpty
		List<Long> categoriasIds) {

}
