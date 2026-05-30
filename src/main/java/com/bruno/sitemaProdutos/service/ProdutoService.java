package com.bruno.sitemaProdutos.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.bruno.sitemaProdutos.dto.produto.ProdutoRequest;
import com.bruno.sitemaProdutos.dto.produto.ProdutoResponse;
import com.bruno.sitemaProdutos.entity.Produto;
import com.bruno.sitemaProdutos.mapper.ProdutoMapper;
import com.bruno.sitemaProdutos.repository.CategoriaRepository;
import com.bruno.sitemaProdutos.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final CategoriaRepository categoriaRepository;
	private final ProdutoMapper produtoMapper;
	
	
	public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository,
			ProdutoMapper produtoMapper) {
		super();
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
		this.produtoMapper = produtoMapper;
	}


	public ProdutoResponse salvar(ProdutoRequest request) {
		Produto produto = produtoMapper.toEntity(request);
		produtoRepository.save(produto);
		return produtoMapper.toResponse(produto);
	}
	
	public ProdutoResponse buscarPorId(Long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
		
		return produtoMapper.toResponse(produto);
	}
	
	public List<ProdutoResponse> listarTodosProdutos() {
		return produtoRepository.findAll().stream().map(produtoMapper::toResponse).toList();
	}
	
	
	public void removerProduto(Long id) {
		if(!produtoRepository.existsById(id)) {
			throw new EntityNotFoundException("ID do produto não encontrado");
		} else {
			produtoRepository.deleteById(id);
		}
	}
	
	public ProdutoResponse atualizarProduto(Long id, ProdutoRequest request) {
		
	
		Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
		produto.setNome(request.nome());
		produto.setPreco(request.preco());
		produto.setCategorias(categoriaRepository.findAllById(request.categoriasIds()));
		
	    produto = produtoRepository.save(produto);

	    return produtoMapper.toResponse(produto);
	}
	
}
 