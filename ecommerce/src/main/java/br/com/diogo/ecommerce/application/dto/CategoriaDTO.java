package br.com.diogo.ecommerce.application.dto;

import lombok.Builder;

@Builder
public record CategoriaDTO(String id, String nome) {
}
