package com.bruno.sistemaProdutos.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDto(

    @NotBlank
    String email,

    @NotBlank
    String password
) {

}
