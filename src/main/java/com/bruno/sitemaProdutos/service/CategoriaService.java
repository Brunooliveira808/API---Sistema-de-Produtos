package com.bruno.sitemaProdutos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bruno.sitemaProdutos.dto.categoria.CategoriaRequest;
import com.bruno.sitemaProdutos.dto.categoria.CategoriaResponse;
import com.bruno.sitemaProdutos.dto.produto.ProdutoResumoResponse;
import com.bruno.sitemaProdutos.entity.Categoria;
import com.bruno.sitemaProdutos.mapper.CategoriaMapper;
import com.bruno.sitemaProdutos.repository.CategoriaRepository;

@Service
public class CategoriaService {

	
	private final CategoriaRepository categoriaRepository;
	private final CategoriaMapper categoriaMapper;
	
	public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
		super();
		this.categoriaRepository = categoriaRepository;
		this.categoriaMapper = categoriaMapper;
	}
	
	public CategoriaResponse salvar(CategoriaRequest request) {
		Categoria categoria = categoriaMapper.toEntity(request);
		categoriaRepository.save(categoria);
		return categoriaMapper.toResponse(categoria);
	}

	public List<CategoriaResponse> listarTodas(){
		return categoriaRepository.findAll().stream().map(categoriaMapper::toResponse).toList();
	}
	
	
	public List<ProdutoResumoResponse> listarProdutosPorCategoria(Long Id) {
		
		Categoria categoria = categoriaRepository.findById(Id).orElseThrow(() -> new RuntimeException("Essa categoria não existe"));
		
	    return categoria.getProdutos()
	            .stream()
	            .map(produto ->
	                    new ProdutoResumoResponse(
	                            produto.getId(),
	                            produto.getNome(),
	                            produto.getPreco()
	                    )
	            ).toList();
		

		
		
		
		
	}
	
	
	
	
}
