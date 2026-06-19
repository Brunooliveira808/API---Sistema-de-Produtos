package com.bruno.sistemaProdutos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.sistemaProdutos.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
