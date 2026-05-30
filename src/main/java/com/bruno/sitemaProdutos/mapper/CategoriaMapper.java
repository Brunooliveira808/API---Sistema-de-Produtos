package com.bruno.sitemaProdutos.mapper;

import org.springframework.stereotype.Component;

import com.bruno.sitemaProdutos.dto.categoria.CategoriaRequest;
import com.bruno.sitemaProdutos.dto.categoria.CategoriaResponse;
import com.bruno.sitemaProdutos.entity.Categoria;

@Component
public class CategoriaMapper {

	
	
	public Categoria toEntity(CategoriaRequest request) {
		 
		Categoria categoria = new Categoria();
		
		categoria.setNome(request.nome());
		
		return categoria;
	}
	
	public CategoriaResponse toResponse(Categoria categoria) {
		
		return new CategoriaResponse(categoria.getId(), categoria.getNome());
	}
}
